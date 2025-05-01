package io.security.springsecuritymaster.domain.user;

public interface UserService {
    //Command, Criteria (요청) ----- Info (응답)
    UserInfo registerUser(UserCommand userCommand);
}
