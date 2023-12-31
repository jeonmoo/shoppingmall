package com.example.shoppingmall.domain.users;

import com.example.shoppingmall.domain.enums.Authority;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

public class CustomUserDetails implements UserDetails, OAuth2User {

    private final Collection<GrantedAuthority> authorities;
    private final String password;
    private final String usersName;
    private final String uid;

    @Builder
    public CustomUserDetails(Authority authority, String password, String usersName, String uid) {
        Collection<GrantedAuthority> collection = new HashSet<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return authority.name();
            }
        });

        this.authorities = collection;
        this.password = password;
        this.usersName = usersName;
        this.uid = uid;
    }

    /**
     * Oauth2User
     */
    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    /**
     * 해당 유저의 권한 목록
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * 비밀번호
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * PK값
     */
    @Override
    public String getUsername() {
        return usersName;
    }

    /**
     * 계정 만료 여부
     * true : 만료 안됨
     * false : 만료
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 계정 잠김 여부
     * true : 잠기지 않음
     * false : 잠김
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 비밀번호 만료 여부
     * true : 만료 안됨
     * false : 만료
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 사용자 활성화 여부
     * ture : 활성화
     * false : 비활성화
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * OAuth2User
     */
    @Override
    public String getName() {
        return null;
    }

    public String getUid() {
        return uid;
    }
}
