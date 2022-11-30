package com.example.springbootsecurity.controller;

import com.example.springbootsecurity.entity.UserDetailImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@Slf4j
public class HelloController {

    // 拥有ADMIN角色才可以访问
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/admin")
    public String admin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetailImpl) {
            UserDetailImpl user = (UserDetailImpl) authentication.getPrincipal();
            log.info("username======" + user.getUsername());
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                log.info("ROLE======" + authority.getAuthority());
            }
        }
        return "admin login";
    }

    //USER角色访问
    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping("/user")
    public String user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetailImpl) {
            UserDetailImpl user = (UserDetailImpl) authentication.getPrincipal();
            log.info("username======" + user.getUsername());
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                log.info("ROLE======" + authority.getAuthority());
            }
        }
        return "user login";
    }

}

