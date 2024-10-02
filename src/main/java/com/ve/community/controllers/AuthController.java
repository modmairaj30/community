package com.ve.community.controllers;


import com.ve.community.constants.CommonConstant;
import com.ve.community.constants.ResponseWrapper;
import com.ve.community.payloads.request.LoginRequest;
import com.ve.community.payloads.request.UsersRequest;
import com.ve.community.payloads.response.UserInfoResponse;
import com.ve.community.payloads.response.UsersResponse;

import com.ve.community.services.UsersService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public ResponseEntity<UserInfoResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        LOGGER.info("AuthController Started");
        long id=1;
        return ResponseEntity.ok().body(new UserInfoResponse(id,
                loginRequest.getUsername(), "abc@tect.com"));

    }
    @GetMapping("/getAllUsers")
    public ResponseWrapper<UsersResponse> getAllUsers(){
        UsersResponse usersList=  usersService.getAllUsers();
        System.out.println("userResponse :"+ usersList);
        return new ResponseWrapper(HttpStatus.OK,"",usersList);
    }


    @PostMapping("/saveUser")
    public ResponseEntity<String> createUser(@Valid @RequestBody UsersRequest usersRequest) {

        System.out.println(usersRequest);
        usersService.createUser(usersRequest);
        return ResponseEntity.ok(CommonConstant.USERS_SUCCESSFULLY);
    }




}
