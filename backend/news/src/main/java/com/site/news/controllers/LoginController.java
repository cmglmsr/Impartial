package com.site.news.controllers;

import com.site.news.enums.UserType;
import com.site.news.model.BaseEntity;
import com.site.news.security.JwtService;
import com.site.news.security.SecurityConfig;
import com.site.news.services.BaseEntityService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private BaseEntityService baseEntityService;

    @Autowired
    private JwtService jwtUtil;


    @PostMapping("/home/login")
    public String login(@RequestBody BaseEntity entity){
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(entity.getUsername(),entity.getPassword()));
            return jwtUtil.generateAccessToken(entity);
        }catch (BadCredentialsException e){
            return "Invalid username or password";
        }
}


}
