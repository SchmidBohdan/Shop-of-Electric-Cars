package com.shop.validator.userValidator;

import com.shop.dao.UserDao;
import com.shop.entity.User;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 5/29/2017.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
        private UserDao userDao;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;


        if(user.getFirstName().isEmpty()){
            throw new UserException(UserValidatorMessages.EMPTY_USER_FIRSTNAME_FIELD);
        }else if (userDao.findByFirstName(user.getFirstName()) != null) {
            throw new UserException(UserValidatorMessages.USER_FIRSTNAME_ALREADY_EXIST);
        }
        else if (user.getLastName().isEmpty()){
                throw new UserException(UserValidatorMessages.EMPTY_USER_LASTNAME_FIELD);
        }else if (userDao.findByLastName(user.getLastName()) != null){
            throw new UserException(UserValidatorMessages.USER_LASTTNAME_ALREADY_EXIST);
        }
        else if (user.getEmail().isEmpty()){
            throw new UserException(UserValidatorMessages.EMPTY_EMAIL);
        }else if (userDao.findByEmail(user.getEmail()) != null){
            throw new UserException(UserValidatorMessages.EMAIL_ALREADY_EXIST);
        }
        else if (user.getNumberPhone().isEmpty()){
            throw new UserException(UserValidatorMessages.EMPTY_NUMBERPHONE);
        }else if (userDao.findByNumberPhone(user.getNumberPhone()) != null){
            throw new UserException(UserValidatorMessages.NUMBERFHONE_ALREADY_EXIST);
        }else if (user.getNumberPhone().length() == 9){
            throw new UserException(UserValidatorMessages.NUMBERPHONE_IS_SHORT);
        }else if (user.getNumberPhone().matches("[0-9]*")==false){
            throw new UserException(UserValidatorMessages.IT_IS_NOT_BE_WORD);
        }
        else if (user.getPassword().isEmpty()){
            throw new UserException(UserValidatorMessages.EMPTY_PASSWORD);
        }else if (user.getPassword().length() < 5){
            throw new UserException(UserValidatorMessages.PASSWORD_IS_SHORT);
        }
        else if (user.getAddress().isEmpty()){
            throw new UserException(UserValidatorMessages.EMPTY_ADRESS);
        }

    }
}
