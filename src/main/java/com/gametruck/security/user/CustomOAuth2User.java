package com.gametruck.security.user;

import com.gametruck.vo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CustomOAuth2User extends LoginUser implements OAuth2User {

    private String providerType;
    private Map<String, Object> attributes;

    public CustomOAuth2User(User user, Map<String, Object> attributes){
        super(user);
        this.providerType = user.getProviderType();
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(getRolename()));
    }

    public String providerType() {
        return providerType;
    }
}
