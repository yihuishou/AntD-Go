package com.jwtsecurity.services.Impl;

import com.jwtsecurity.dao.RoleDao;
import com.jwtsecurity.model.CommonRole;
import com.jwtsecurity.services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LadyLady on 2019-04-26.
 */
@Service
public class RoleServicesImpl implements RoleServices {


    @Autowired
    private RoleDao roleDao;


    @Override
    public boolean deleteRole(Integer id) {

        try {
            roleDao.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public CommonRole addRole(CommonRole commonRole) {

        if (commonRole.getId() != null) {
            return null;
        }

        return roleDao.save(commonRole);
    }

    @Override
    public CommonRole updateRole(CommonRole commonRole) {

        if (commonRole.getId() != null) {
            return roleDao.save(commonRole);
        }

        return null;
    }

    @Override
    public CommonRole findOneRole(Integer id) {
        return roleDao.findOne(id);
    }
}
