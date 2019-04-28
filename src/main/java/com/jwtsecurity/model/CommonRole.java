package com.jwtsecurity.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by LadyLady on 2019-04-19.
 */
@Data
@Entity
public class CommonRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String role;

    private String detail;

    private String note;

    @JoinColumn(name = "roleID")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CommonPermission> permissionList;
}
