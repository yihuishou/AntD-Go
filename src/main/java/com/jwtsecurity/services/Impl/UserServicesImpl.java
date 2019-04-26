package com.jwtsecurity.services.Impl;

import com.jwtsecurity.dao.UserDao;
import com.jwtsecurity.model.CommonUser;
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
public class UserServicesImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final CommonUser commonUser = new CommonUser();

        commonUser.setUsername(username);

        return userDao.findOne(Example.of(commonUser));
    }

}
