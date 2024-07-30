package com.ve.community.controllers;


import com.ve.community.payloads.request.LoginRequest;
import com.ve.community.payloads.response.UserInfoResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@CrossOrigin(origins = "*", maxAge = 3600)
//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    @PostMapping(value = "/signin", produces = "application/json", consumes = "application/json")
    public ResponseEntity<UserInfoResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        LOGGER.info("AuthController Started");
        long id=1;
        return ResponseEntity.ok().body(new UserInfoResponse(id,
                loginRequest.getUsername(),"abc@tect.com"));
    }



}
