package com.gametruck.security.service;

import com.gametruck.mapper.UserMapper;
import com.gametruck.security.oauth.exception.OAuthProviderMissMatchException;
import com.gametruck.security.oauth.info.OAuth2UserInfo;
import com.gametruck.security.oauth.info.OAuth2UserInfoFactory;
import com.gametruck.security.user.CustomOAuth2User;
import com.gametruck.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserMapper userMapper;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // 로그인방식 가져오기
        String providerType = userRequest.getClientRegistration().getRegistrationId();
        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(providerType, oAuth2User.getAttributes());
        User savedUser = userMapper.getUserById(userInfo.getId());

        if (savedUser != null) {
            if (!providerType.equals(savedUser.getProviderType())) {
                throw new OAuthProviderMissMatchException("소셜로그인 공급자가 일치하지 않습니다.");
            }
        } else {
            savedUser = createUser(userInfo, providerType);
        }
        return new CustomOAuth2User(savedUser, userInfo.getAttributes());
    }

    private User createUser(OAuth2UserInfo userInfo, String providerType) {
        User user = User.builder()
                        .id(userInfo.getId())
                        .email(userInfo.getEmail())
                        .name(userInfo.getName())
                        .providerType(providerType)
                        .build();
        userMapper.createUser(user);
        user.setRoleName("ROLE_USER");
        return user;
    }
}
