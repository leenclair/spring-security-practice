package io.security.springsecuritymaster.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class UserCommand {

    private final String username;
    private final String password;
    private final String roles;
    private final int age;

    public User toEntity(String encodingPassword) {
        return User.builder()
                .username(username)
                .password(encodingPassword)
                .roles(roles)
                .age(age)
                .build();
    }

}
