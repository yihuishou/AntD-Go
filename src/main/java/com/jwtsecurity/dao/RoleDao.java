package com.jwtsecurity.dao;

import com.jwtsecurity.model.CommonRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LadyLady on 2019-04-19.
 */
public interface RoleDao extends JpaRepository<CommonRole,Integer> {
}
