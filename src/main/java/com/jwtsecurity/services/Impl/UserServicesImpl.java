package com.jwtsecurity.services.Impl;

import com.jwtsecurity.dao.UserDao;
import com.jwtsecurity.model.CommonUser;
import com.jwtsecurity.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by LadyLady on 2019-04-19.
 */
@Service
public class UserServicesImpl implements UserDetailsService, UserServices {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final CommonUser commonUser = new CommonUser();

        commonUser.setUsername(username);

        return userDao.findOne(Example.of(commonUser));
    }


    public CommonUser addUser(CommonUser commonUser) {


        if (commonUser.getId() != null) {
            return null;
        }

        return userDao.save(commonUser);
    }


    public boolean deleteUser(Integer id) {
        try {
            userDao.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public CommonUser updateUser(CommonUser commonUser) {

        if (commonUser.getId() != null) {
            return userDao.save(commonUser);
        }
        return null;


    }


    public CommonUser findOneUser(Integer id) {


        return userDao.findOne(id);
    }


}
