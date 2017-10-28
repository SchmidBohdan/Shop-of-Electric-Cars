package com.shop.serviceImpl;

import java.util.List;


import com.shop.dao.SexDao;
import com.shop.dao.SpeceficationDao;
import com.shop.entity.Role;
import com.shop.entity.Sex;
import com.shop.entity.Specefication;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shop.dao.UserDao;
import com.shop.entity.User;
import com.shop.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {


    @Autowired
    private UserDao userDao;
    @Autowired
    private SpeceficationDao speceficationDao;
    @Autowired
    private SexDao sexDao;
    @Autowired
    @Qualifier("userValidator")
    private Validator validator;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void save(User user, int sexId) throws Exception {

        validator.validate(user);
        Sex sex = sexDao.findOne(sexId);
        userDao.saveAndFlush(user);
        user.setSex(sex);
        user.setRole(Role.ROLE_USER);
//		encoder.matches(12345, "qwerty");
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);


    }

    public List<User> findAll() {

        return userDao.findAll();
    }

    public User findOne(int id) {

        return userDao.findOne(id);
    }

    public void delete(int id) {
        userDao.delete(id);

    }

    public void update(User user) {
        userDao.save(user);

    }

    @Override
    public User findByUuid(String uuid) {
        return userDao.findByUuid(uuid);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.findByFirstName(s);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public BCryptPasswordEncoder getEncoder() {
        return encoder;
    }

    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }


    @Override
    public User findUserWithSpecefication(int id) {

        User user = userDao.findUserWithSpecefications(id);

        return user;
    }
}




