package com.pharma.PharmaApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.PharmaApp.dto.user.LoginDTO;
import com.pharma.PharmaApp.dto.user.LoginReturnDTO;
import com.pharma.PharmaApp.dto.user.RegisterDTO;
import com.pharma.PharmaApp.dto.user.ResponseDTO;
import com.pharma.PharmaApp.exceptions.CustomException;
import com.pharma.PharmaApp.exceptions.TokenFailureException;
import com.pharma.PharmaApp.service.UserService;

@RequestMapping("user")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/register")
    public ResponseDTO register(@RequestBody RegisterDTO regDTO) throws CustomException {
        return userService.register(regDTO);
    }
	
    @PostMapping("/login")
    public LoginReturnDTO login(@RequestBody LoginDTO loginDTO) throws CustomException, TokenFailureException {
        return userService.login(loginDTO);
    }
}
