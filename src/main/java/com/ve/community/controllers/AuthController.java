package com.ve.community.controllers;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ve.community.constants.ResponseWrapper;
import com.ve.community.payloads.request.LoginRequest;
import com.ve.community.payloads.request.UsersRequest;
import com.ve.community.payloads.response.UsersResponse;
import com.ve.community.services.UsersService;

import jakarta.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private ModelMapper modelMapper;



    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    @PostMapping(value = "/signin", produces = "application/json", consumes = "application/json")
    public ResponseWrapper<UsersResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        LOGGER.info("AuthController Started");
        UsersResponse usersResponse = usersService.getUserByEmailId(loginRequest.getEmail(), loginRequest.getPassword());
        if(usersResponse==null) {
        return new ResponseWrapper<UsersResponse>(HttpStatus.OK,"User not Exists",usersResponse);
        }
        return new ResponseWrapper<UsersResponse>(HttpStatus.OK,"User logged Successfully",usersResponse);
    }
//    @GetMapping("/getAllUsers")
//    public ResponseWrapper<UsersResponse> getAllUsers(){
//        UsersResponse usersList=  usersService.getAllUsers();
//        System.out.println("userResponse :"+ usersList);
//        return new ResponseWrapper<UsersResponse>(HttpStatus.OK,"",usersList);
//    }

    @GetMapping("/getAllUsers")
    public ResponseWrapper<List<UsersResponse>> getAllUsers(){
        List<UsersResponse> usersList=usersService.getAllUsers();
        return new ResponseWrapper(HttpStatus.OK,"",usersList);
    }


    @PostMapping("/saveUser")
    public ResponseWrapper<String> createUser(@Valid @RequestBody UsersRequest usersRequest) {
    	return new ResponseWrapper<String>(HttpStatus.OK, usersService.createUser(usersRequest),"");
    }




}
