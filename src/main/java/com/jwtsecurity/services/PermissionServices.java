package com.jwtsecurity.services;

import com.jwtsecurity.model.CommonPermission;

/**
 * Created by LadyLady on 2019-04-26.
 */
public interface PermissionServices {


    boolean deletePermission(Integer id);

    CommonPermission addPermission(CommonPermission commonPermission);

    CommonPermission updatePermission(CommonPermission commonPermission);

    CommonPermission findOnePermission(Integer id);


}
