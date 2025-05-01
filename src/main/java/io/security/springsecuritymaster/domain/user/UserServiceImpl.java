package io.security.springsecuritymaster.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserStore userStore;

    @Override
    public UserInfo registerUser(UserCommand command) {
        User initUser = command.toEntity(passwordEncoder.encode(command.getPassword()));
        User user = userStore.store(initUser);
        return new UserInfo(user);
    }
}
