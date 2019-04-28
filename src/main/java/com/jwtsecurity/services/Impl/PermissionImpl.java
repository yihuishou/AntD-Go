package com.jwtsecurity.services.Impl;

import com.jwtsecurity.dao.PermissionDao;
import com.jwtsecurity.model.CommonPermission;
import com.jwtsecurity.services.PermissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LadyLady on 2019-04-26.
 */
@Service
public class PermissionImpl implements PermissionServices {


    @Autowired
    private PermissionDao permissionDao;


    @Override
    public boolean deletePermission(Integer id) {


        try {
            permissionDao.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    @Override
    public CommonPermission addPermission(CommonPermission commonPermission) {

        if (commonPermission.getId() != null) {
            return null;
        }
        return permissionDao.save(commonPermission);

    }

    @Override
    public CommonPermission updatePermission(CommonPermission commonPermission) {
        return permissionDao.save(commonPermission);
    }

    @Override
    public CommonPermission findOnePermission(Integer id) {
        return permissionDao.findOne(id);
    }
}
