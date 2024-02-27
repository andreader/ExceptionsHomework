package sky.pro.ExceptionsHomework.service;

import org.springframework.stereotype.Service;
import sky.pro.ExceptionsHomework.exceptions.WrongLoginException;
import sky.pro.ExceptionsHomework.exceptions.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LoginPasswordServiceImpl implements LoginPasswordService {

    private static final String VALIDATE_PATTERN = "^[a-zA-Z0-9-_]+$";

    @Override
    public void isLoginValid(String login) throws WrongLoginException {

        if (login.length() > 20) {
            throw new WrongLoginException("Логин не может быть длиннее 20 знаков.");
        }

        if (!login.matches(VALIDATE_PATTERN)) {
            throw new WrongLoginException("Логин не соответствует требованиям." +
                    "Логин должен содержать в себе только латинские буквы," +
                    "цифры и знак подчеркивания");
        }
    }

    @Override
    public void isPasswordValid(String password, String confirmPassword) throws WrongPasswordException {
        if (password.length() > 20) {
            throw new WrongPasswordException("Пароль не может быть длиннее 20 знаков.");
        }

        if (password.equals(confirmPassword) == false) {
            throw new WrongPasswordException("Пароли должны совпадать.");
        }

        if (!password.matches(VALIDATE_PATTERN)) {
            throw new WrongPasswordException("Пароль не соответствует требованиям." +
                    "Пароль должен содержать в себе только латинские буквы," +
                    "цифры и знак подчеркивания");
        }

    }

}

