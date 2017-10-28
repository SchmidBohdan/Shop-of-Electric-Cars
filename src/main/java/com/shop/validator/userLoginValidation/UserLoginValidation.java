package com.shop.validator.userLoginValidation;

import com.shop.dao.UserDao;
import com.shop.entity.User;
import com.shop.validator.Validator;
import com.shop.validator.userValidator.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 6/28/2017.
 */
@Component
public class UserLoginValidation implements Validator {


    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserDao userDao;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

        if (user.getFirstName().isEmpty() && !user.getPassword().isEmpty()) {
            throw new UserException(UserLoginValidationMessages.EMPTY_USERNAME_FIELD);
        }
        else if (user.getPassword().isEmpty() && !user.getFirstName().isEmpty()) {
            throw new UserException(UserLoginValidationMessages.EMPTY_PASSWORD_FIELD);
        }else if (user.getPassword().isEmpty() && user.getFirstName().isEmpty()) {
            throw new UserException(UserLoginValidationMessages.EMPTY_USERNAME_AND_PASSWORD);
        }
        else if (userDao.findByFirstName(user.getFirstName()) == null) {
            throw new UserException(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD);
        } else if (encoder.matches(user.getPassword(),
                userDao.findByFirstName(user.getFirstName()).getPassword())){
            throw new UserException(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD);
        }


    }
}
