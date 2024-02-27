package sky.pro.ExceptionsHomework.service;

import sky.pro.ExceptionsHomework.exceptions.WrongLoginException;
import sky.pro.ExceptionsHomework.exceptions.WrongPasswordException;

public interface LoginPasswordService {
    public void isLoginValid(String login) throws WrongLoginException;

    public void isPasswordValid(String password, String confirmPassword) throws WrongPasswordException;

}
