package com.jwtsecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created by LadyLady on 2019-04-19.
 */
@EnableResourceServer
@Configuration
public class ResourceConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/article/**")
            .permitAll()
            .and()
            .authorizeRequests()
            .anyRequest()
            .hasRole("user")
            .and()
            .httpBasic()
            .disable();
    }


}
