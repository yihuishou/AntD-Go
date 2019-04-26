package com.jwtsecurity.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by LadyLady on 2019-04-19.
 */
@Data
@Entity
public class CommonPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String permission;

    private String detail;

    private String note;
}
