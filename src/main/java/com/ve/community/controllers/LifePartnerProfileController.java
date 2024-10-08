package com.ve.community.controllers;

import com.ve.community.constants.CommonConstant;
import com.ve.community.constants.ResponseWrapper;
import com.ve.community.models.LifePartnerProfile;
import com.ve.community.payloads.request.LifePartnerProfileRequest;
import com.ve.community.payloads.request.UsersRequest;
import com.ve.community.payloads.response.LifePartnerProfileResponse;
import com.ve.community.payloads.response.UsersResponse;
import com.ve.community.services.LifePartnerProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/auth")
public class LifePartnerProfileController {
    @Autowired
    LifePartnerProfileService lifePartnerProfileService;
    @GetMapping("/getAllLifePartnerProfiles")
    public ResponseWrapper<List<LifePartnerProfileResponse>> getAllProfiles(){
        List<LifePartnerProfileResponse> profilesList= lifePartnerProfileService.getAllProfiles();
        return new ResponseWrapper(HttpStatus.OK,"",profilesList);
    }

    @PostMapping("/saveLifePartnerProfile")
    public ResponseEntity<String> createProfile(@Valid @RequestBody LifePartnerProfileRequest lifePartnerProfileRequest) {
        lifePartnerProfileService.createProfile(lifePartnerProfileRequest);
        return ResponseEntity.ok(CommonConstant.PROFILE_SUCCESSFULLY);
    }
}
