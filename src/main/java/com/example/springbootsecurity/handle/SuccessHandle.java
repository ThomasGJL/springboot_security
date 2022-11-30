package com.example.springbootsecurity.handle;

import com.example.springbootsecurity.entity.GrantedAuthorityImpl;
import com.example.springbootsecurity.entity.UserDetailImpl;
import com.example.springbootsecurity.utils.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class SuccessHandle implements AuthenticationSuccessHandler {
    @SneakyThrows
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ObjectMapper objectMapper = new ObjectMapper();

        if (auth.getPrincipal() instanceof UserDetailImpl) {
            UserDetailImpl principal = (UserDetailImpl) auth.getPrincipal();
            JWT jwt = new JWT(objectMapper.writeValueAsString(principal));
            httpServletResponse.getWriter().write("{\"code\": \"200\", \"msg\": \"登录成功\"}"
                    + "\n用户名：" + ((UserDetailImpl) auth.getPrincipal()).getUsername()
                    + "\n角色:" +  Arrays.toString(auth.getAuthorities().toArray(new GrantedAuthorityImpl[0]))
                    + "\ntoken:\n" + jwt
            );
        }
    }
}
