package me.dev.config;

import me.dev.dto.CustomUserDetails;
import me.dev.entity.User;
import me.dev.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Set;

public class JdbcUserDetailsService implements UserDetailsService {
    private final static Set<GrantedAuthority> AUTHENTICATED_USER_AUTHORITIES =
            Collections.singleton(new SimpleGrantedAuthority("USER"));

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found!");
        }
        return new CustomUserDetails(user.getId(),
                username,
                user.getPassword(),
                !user.getLocked(),
                !user.getExpired(),
                !user.getExpired(),
                AUTHENTICATED_USER_AUTHORITIES);
    }
}
