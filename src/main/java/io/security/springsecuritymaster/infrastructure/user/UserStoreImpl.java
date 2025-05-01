package io.security.springsecuritymaster.infrastructure.user;

import io.security.springsecuritymaster.common.exception.InvalidParamException;
import io.security.springsecuritymaster.domain.user.User;
import io.security.springsecuritymaster.domain.user.UserStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {

    private final UserRepository userRepository;

    @Override
    public User store(User user) {
        if(StringUtils.isEmpty(user.getUserToken())) throw new InvalidParamException("user.userToken is empty");
        if(StringUtils.isEmpty(user.getUsername())) throw new InvalidParamException("user.username is empty");
        if(StringUtils.isEmpty(user.getPassword())) throw new InvalidParamException("user.password is empty");

        return userRepository.save(user);
    }
}
