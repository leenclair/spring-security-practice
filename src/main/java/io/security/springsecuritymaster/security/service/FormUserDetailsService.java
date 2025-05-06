package io.security.springsecuritymaster.security.service;

import io.security.springsecuritymaster.domain.user.User;
import io.security.springsecuritymaster.domain.user.UserContext;
import io.security.springsecuritymaster.infrastructure.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service("userDetailsService")
@RequiredArgsConstructor
public class FormUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }
        log.info("Loading user by username: {}", username);
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.get().getRoles()));

        return new UserContext(user.get(), authorities);
    }
}
