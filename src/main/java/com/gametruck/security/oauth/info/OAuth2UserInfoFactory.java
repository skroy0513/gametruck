package com.gametruck.security.oauth.info;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String providerType, Map<String, Object> attributes) {
        switch (providerType) {
            case "kakao" :
                return new KakaoOAuth2UserInfo(attributes);
            case "naver" :
                return new NaverOAuth2UserInfo(attributes);
            default:
                throw new IllegalArgumentException("유효한 소셜로그인 공급자가 아닙니다.");
        }
    }
}
