package com.jwtsecurity.services;

import com.jwtsecurity.model.CommonRole;
import org.springframework.stereotype.Service;

/**
 * Created by LadyLady on 2019-04-26.
 */
@Service
public interface RoleServices {


    boolean deleteRole(Integer id);

    CommonRole addRole(CommonRole commonRole);


    CommonRole updateRole(CommonRole commonRole);


    CommonRole findOneRole(Integer id);

}
