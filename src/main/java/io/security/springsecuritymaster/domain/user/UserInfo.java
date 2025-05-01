package io.security.springsecuritymaster.domain.user;

import lombok.Getter;

@Getter
public class UserInfo {
    private final Long id;
    private final String userToken;
    private final String username;
    private final String password;
    private final String roles;
    private final int age;

    public UserInfo(User user){
        this.id = user.getId();
        this.userToken = user.getUserToken();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.age = user.getAge();
    }
}
