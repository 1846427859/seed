package com.example.demo.config.security;

import com.example.demo.mapper.AssignPrivilegeMapper;
import com.example.demo.mapper.SysAccountMapper;
import com.example.demo.mapper.SysAuthorityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(SysAccountMapper accountMapper, SysAuthorityMapper authorityMapper, AssignPrivilegeMapper assignPrivilegeMapper) {
        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();
        userDetailsService.setAccountMapper(accountMapper);
        userDetailsService.setAssignPrivilegeMapper(assignPrivilegeMapper);
        userDetailsService.setAuthorityMapper(authorityMapper);
        return userDetailsService;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and().authorizeRequests().antMatchers("/**").authenticated()
                .and().csrf().disable();
        // 用户不能同时登陆，第二个无法登录
        http.sessionManagement().maximumSessions(1).expiredUrl("/login");
    }

}
