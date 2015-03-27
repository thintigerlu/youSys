package com.lu.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoaderListener;

import com.lu.model.AppError;
import com.lu.model.login.LoginRequest;
import com.lu.model.login.LoginResponse;

@RestController
@RequestMapping("/login")
public class LoginController {
 @Autowired
 @Qualifier("authenticationManager")
 AuthenticationManager authenticationManager;


    @RequestMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest request, HttpServletRequest req) {
     LoginResponse response = new LoginResponse();
     for (String s:ContextLoaderListener.getCurrentWebApplicationContext().getBeanDefinitionNames()){
      System.out.println("name:"+s);
      System.out.println(ContextLoaderListener.getCurrentWebApplicationContext().getBean(s));
     }

     UsernamePasswordAuthenticationToken token =
       new UsernamePasswordAuthenticationToken(request.getLoginId(), request.getPassword());
     token.setDetails(new WebAuthenticationDetails(req));
     Authentication auth = authenticationManager.authenticate(token);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(auth);
        
     
     if (auth.isAuthenticated()) {
       HttpSession session = req.getSession(true);
             session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
             for (GrantedAuthority ga:auth.getAuthorities()){
              System.out.println(ga.getAuthority());
             }
        }else{
            SecurityContextHolder.getContext().setAuthentication(null);

       AppError e = new AppError("notLogin", "invalid ID or Password", null);
       response.setErrors(new ArrayList<AppError>());
       response.getErrors().add(e);
        }   
/*     if (!"test".equals(request.getLoginId()) || !"pass".equals(request.getPassword())) {
      TestError e = new TestError("notLogin", "invalid ID or Password", null);
      response.setErrors(new ArrayList<TestError>());
      response.getErrors().add(e);
     }
*/  return response;
    }
    
}


