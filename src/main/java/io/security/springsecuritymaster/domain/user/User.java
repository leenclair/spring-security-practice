package io.security.springsecuritymaster.domain.user;

import io.security.springsecuritymaster.common.util.TokenGenerator;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    private static final String USER_PREFIX = "user_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userToken;
    private String username;
    private String password;
    private String roles;
    private int age;

    @Builder
    public User(String username,
                String password,
                String roles,
                int age) {
        this.userToken = TokenGenerator.randomCharacterWithPrefix(USER_PREFIX);
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.age = age;
    }
}
