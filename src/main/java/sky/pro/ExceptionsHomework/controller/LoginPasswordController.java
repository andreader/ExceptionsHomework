package sky.pro.ExceptionsHomework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.ExceptionsHomework.exceptions.WrongLoginException;
import sky.pro.ExceptionsHomework.exceptions.WrongPasswordException;
import sky.pro.ExceptionsHomework.service.LoginPasswordServiceImpl;

@RestController
public class LoginPasswordController {
    private final LoginPasswordServiceImpl loginPasswordService;

    public LoginPasswordController(LoginPasswordServiceImpl loginPasswordService) {
        this.loginPasswordService = loginPasswordService;
    }

    @GetMapping(path = "/login")
    public void validation(@RequestParam("login") String login) {
        try {
            loginPasswordService.isLoginValid(login);
        } catch (WrongLoginException e) {
            throw new RuntimeException("Ошибка с введенным логином. " + e.getMessage());
        }
    }

    @GetMapping(path = "/pass")
    public void validation(@RequestParam("pass") String password,
                           @RequestParam("confirmpass") String confirmPassword) {
        try {
            loginPasswordService.isPasswordValid(password, confirmPassword);
        } catch (WrongPasswordException e) {
            throw new RuntimeException("Ошибка с введенным паролем. " + e.getMessage());
        }
    }
}
