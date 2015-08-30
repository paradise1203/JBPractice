package com.aidar;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private List<GrantedAuthority> authenticationAgainstDB(String name, String password) {
        Integer userId = jdbcTemplate.queryForObject("SELECT user_id FROM users WHERE user_name=?", new Object[]{name}, Integer.class);
        String authority = null;
        if (userId != null)
            authority = jdbcTemplate.queryForObject("SELECT authority FROM user_roles WHERE user_id=?", new Object[]{userId}, String.class);
        else
            throw new AuthenticationException("asd") {
            };
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        ;
        if (authority != null)
            grantedAuthorities.add(new SimpleGrantedAuthority(authority));
        else
            throw new AuthenticationException("asd") {
            };
        return grantedAuthorities;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<GrantedAuthority> grantedAuthorities = authenticationAgainstDB(name, password);
        return new UsernamePasswordAuthenticationToken(name, password, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}
