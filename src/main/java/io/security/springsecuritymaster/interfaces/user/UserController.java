package io.security.springsecuritymaster.interfaces.user;

import io.security.springsecuritymaster.domain.user.UserCommand;
import io.security.springsecuritymaster.domain.user.UserInfo;
import io.security.springsecuritymaster.domain.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/login/login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "/login/signup";
    }

    @PostMapping("/signup")
    public String signup(UserDto.RegisterRequest request) {
        log.info("Signup request: {}", request);
        UserCommand command = request.toCommand();
        UserInfo userInfo = userService.registerUser(command);
        UserDto.RegisterResponse response = new UserDto.RegisterResponse(userInfo);
        log.info("signup response: {}", response);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication();
        if(authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "redirect:/login";
    }
}
