package com.example.Spring_security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.io.IOException;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        if(isAdmin){
            setDefaultTargetUrl("/admin/home");    //is he is a admin he will be redirected to admin page
        }else {
            setDefaultTargetUrl("/user/home");     //if he is not a admin he will be a normal user so he will be redirected to user page

        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
