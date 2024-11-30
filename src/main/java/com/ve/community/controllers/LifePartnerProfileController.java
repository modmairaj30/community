package com.ve.community.controllers;

import com.ve.community.constants.CommonConstant;
import com.ve.community.constants.ResponseWrapper;
import com.ve.community.models.LifePartnerProfile;
import com.ve.community.payloads.request.LifePartnerProfileRequest;
import com.ve.community.payloads.response.LifePartnerProfileResponse;
import com.ve.community.services.LifePartnerProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class LifePartnerProfileController {

    @Autowired
    LifePartnerProfileService lifePartnerProfileService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getAllLifePartnerProfiles")
    public ResponseWrapper<List<LifePartnerProfileResponse>> getAllProfiles() {
        List<LifePartnerProfileResponse> profilesList = lifePartnerProfileService.getAllProfiles();
        return new ResponseWrapper<>(HttpStatus.OK, "Profiles fetched successfully", true, profilesList);
    }

    @PostMapping("/saveLifePartnerProfile")
    public ResponseWrapper<Void> createProfile(@Valid @RequestBody LifePartnerProfileRequest lifePartnerProfileRequest) {
        lifePartnerProfileService.createProfile(lifePartnerProfileRequest);
        return new ResponseWrapper<>(HttpStatus.OK, CommonConstant.PROFILE_SUCCESSFULLY, true);
    }

   /* @GetMapping("/LifePartnerProfile/{communityIdNo}")
    public ResponseWrapper<LifePartnerProfile> getProfileById(@PathVariable Integer communityIdNo) {
        LifePartnerProfile profile = lifePartnerProfileService.getUserById(communityIdNo);
        return new ResponseWrapper<>(HttpStatus.OK, "Profile fetched successfully", true, profile);
    }*/
    @GetMapping("/LifePartnerProfile/{communityIdNo}")
    public ResponseWrapper<LifePartnerProfileResponse> getProfileById(@PathVariable Integer communityIdNo) {
        LifePartnerProfile profile = lifePartnerProfileService.getUserById(communityIdNo);

        // Use ModelMapper to map the entity to the response DTO
        LifePartnerProfileResponse response = modelMapper.map(profile, LifePartnerProfileResponse.class);

        return new ResponseWrapper<>(HttpStatus.OK, "Profile fetched successfully", true, response);
    }
    @DeleteMapping("/deleteLifePartnerProfile/{communityIdNo}")
    public ResponseWrapper<Void> deleteProfile(@PathVariable Integer communityIdNo) {
        lifePartnerProfileService.deleteProfile(communityIdNo);
        return new ResponseWrapper<>(HttpStatus.OK, CommonConstant.PROFILE_DELETED_SUCCESSFULLY, true);
    }

    @PutMapping("/updateLifePartnerProfile/{communityIdNo}")
    public ResponseWrapper<Void> updateProfile(
            @PathVariable Integer communityIdNo,
            @Valid @RequestBody LifePartnerProfileRequest lifePartnerProfileRequest) {
        lifePartnerProfileService.updateProfile(communityIdNo, lifePartnerProfileRequest);
        return new ResponseWrapper<>(HttpStatus.OK, CommonConstant.PROFILE_UPDATED_SUCCESSFULLY, true);
    }

    @PatchMapping("/updateProfileStatus/{communityIdNo}")
    public ResponseWrapper<Void> updateProfileStatus(
            @PathVariable Integer communityIdNo,
            @RequestParam String statusType,
            @RequestParam String statusValue) {
        lifePartnerProfileService.updateProfileStatus(communityIdNo, statusType, statusValue);
        return new ResponseWrapper<>(HttpStatus.OK, "Profile status updated successfully", true);
    }
}
