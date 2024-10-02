package com.ve.community.controllers;

import com.ve.community.constants.CommonConstant;
import com.ve.community.constants.ResponseWrapper;
import com.ve.community.payloads.request.CommunityBusinessRequest;
import com.ve.community.payloads.request.LifePartnerProfileRequest;
import com.ve.community.payloads.response.CommunityBusinessResponse;
import com.ve.community.payloads.response.LifePartnerProfileResponse;
import com.ve.community.services.CommunityBusinessService;
import com.ve.community.services.LifePartnerProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/auth")
public class CommunityBusinessController {
    @Autowired
        CommunityBusinessService communityBusinessService;
        @GetMapping("/getAllBusiness")
        public ResponseWrapper<List<CommunityBusinessResponse>> getAllBusiness(){
            List<CommunityBusinessResponse> profilesList=communityBusinessService.getCommunity();
            return new ResponseWrapper(HttpStatus.OK,"",profilesList);
        }

        @PostMapping("/saveBusiness")
        public ResponseEntity<String> createBusiness(@Valid @RequestBody CommunityBusinessRequest communityBusinessRequest) {
            communityBusinessService.createCommunity(communityBusinessRequest);
            return ResponseEntity.ok(CommonConstant.BUSINESS_SUCCESSFULLY);
        }
    }


