package com.jwtsecurity.services;

import com.jwtsecurity.model.CommonUser;

/**
 * Created by LadyLady on 2019-04-28.
 */
public interface UserServices {

    public CommonUser addUser(CommonUser commonUser);


    public boolean deleteUser(Integer id);


    public CommonUser updateUser(CommonUser commonUser);


    public CommonUser findOneUser(Integer id);
}
