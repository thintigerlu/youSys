package com.lu.web.controller;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lu.model.AppError;
import com.lu.model.login.LoginRequest;
import com.lu.model.login.LoginResponse;


@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
    	LoginResponse response = new LoginResponse();
    	if (!"test".equals(request.getLoginId()) || !"pass".equals(request.getPassword())) {
    		AppError e = new AppError("notLogin", "invalid ID or Password", null);
    		response.setErrors(new ArrayList<AppError>());
    		response.getErrors().add(e);
    	}
		return response;
    }
    
}

