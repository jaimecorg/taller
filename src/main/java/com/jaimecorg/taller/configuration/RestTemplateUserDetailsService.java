package com.jaimecorg.taller.configuration;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUserDetailsService implements UserDetailsService {

    private RestTemplate restTemplate;

    public RestTemplateUserDetailsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String apiUrl = "http://localhost:8081/seguridad//usuarios/{username}";
        User user = restTemplate.getForObject(apiUrl, User.class, username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        UserDetails userDetails = User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthorities())
                .build();

        return userDetails;
    }
}
