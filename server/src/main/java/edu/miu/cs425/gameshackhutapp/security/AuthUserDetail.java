package edu.miu.cs425.gameshackhutapp.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.cs425.gameshackhutapp.model.Role;
import edu.miu.cs425.gameshackhutapp.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AuthUserDetail implements UserDetails{

    private String email;

    @JsonIgnore
    private String password;

    private List<Role> roles;

    public AuthUserDetail (User user){

        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}