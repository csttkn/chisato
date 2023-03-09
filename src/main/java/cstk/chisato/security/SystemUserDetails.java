package cstk.chisato.security;

import cstk.chisato.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SystemUserDetails implements UserDetails {

    private User user;

    private enum USER_STATE {
        OK('0'),
        DISABLE('1'),
        LOCK('2'),
        EXPIRED('3');

        private char value;
        private USER_STATE(char value) {
            this.value = value;
        }

        public boolean equals(char val){
            return this.value == val;
        }

    }

    public SystemUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("TEST"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !USER_STATE.EXPIRED.equals(user.getState());
    }

    @Override
    public boolean isAccountNonLocked() {
        return !USER_STATE.LOCK.equals(user.getState());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !USER_STATE.DISABLE.equals(user.getState());
    }
}
