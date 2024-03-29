package com.lesliefish.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configura(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
    }

}
