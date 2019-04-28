package com.jwtsecurity.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by LadyLady on 2019-04-19.
 */
@Entity
@Data
public class CommonUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String note;

    private Boolean unExpired = true;

    private Boolean unLocked = true;

    private Boolean Enabled = true;

    @JoinColumn(name = "userID")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CommonRole> roleList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();

        roleList.forEach(commonRole -> {

                    final String role = commonRole.getRole();

                    simpleGrantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" + role));

                    commonRole.getPermissionList().forEach(commonPermission -> {

                        simpleGrantedAuthorityList.add(new SimpleGrantedAuthority(commonPermission.getPermission()));
                    });
                }

        );

        return simpleGrantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.unExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.unLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.Enabled;
    }

}
