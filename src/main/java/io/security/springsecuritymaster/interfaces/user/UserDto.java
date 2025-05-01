package io.security.springsecuritymaster.interfaces.user;

import io.security.springsecuritymaster.domain.user.UserCommand;
import io.security.springsecuritymaster.domain.user.UserInfo;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        @NotEmpty(message = "username 은 필수값입니다")
        public String username;

        @NotEmpty(message = "password 는 필수값입니다")
        private String password;

        private String roles;
        private int age;

        public UserCommand toCommand() {
            return UserCommand.builder()
                    .username(username)
                    .password(password)
                    .roles(roles)
                    .age(age)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class RegisterResponse {
        private final String userToken;
        private final String username;
        private final String roles;
        private final int age;

        public RegisterResponse(UserInfo userInfo) {
            this.userToken = userInfo.getUserToken();
            this.username = userInfo.getUsername();
            this.roles = userInfo.getRoles();
            this.age = userInfo.getAge();
        }
    }

}
