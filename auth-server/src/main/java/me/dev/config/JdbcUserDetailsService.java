package me.dev.config;

import me.dev.dto.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Set;

public class JdbcUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(JdbcUserDetailsService.class);

    private final static Set<GrantedAuthority> AUTHENTICATED_USER_AUTHORITIES =
            Collections.singleton(new SimpleGrantedAuthority("ADMIN_USER"));


    private final static String FETCH_USER_QUERY =
            "select u.id,u.password,u.locked,u.expired from USER u where u.username=:username";

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDetailsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return jdbcTemplate.queryForObject(FETCH_USER_QUERY, new String[]{username},
                    (rs, i) ->
                            new CustomUserDetails(rs.getInt("id"),
                                    username,
                                    rs.getString("password"),
                                    !rs.getBoolean("locked"),
                                    !rs.getBoolean("expired"),
                                    !rs.getBoolean("expired"),
                                    AUTHENTICATED_USER_AUTHORITIES)
            );
        } catch (EmptyResultDataAccessException e) {
            logger.debug(this.toString(),e);
            throw new UsernameNotFoundException("user not found!");
        }
    }
}
