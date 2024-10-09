package com.ve.community.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ve.community.constants.CommonConstant;
import com.ve.community.constants.ResponseWrapper;
import com.ve.community.models.CommunityBusiness;
import com.ve.community.payloads.request.CommunityBusinessRequest;
import com.ve.community.payloads.response.CommunityBusinessResponse;
import com.ve.community.services.CommunityBusinessService;

import jakarta.validation.Valid;
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
        
        @GetMapping("/bussiness/{communityIdNo}")
        public ResponseEntity<CommunityBusiness> getBusinessById(@PathVariable Integer communityIdNo) {
            CommunityBusiness business = communityBusinessService.getBusinessById(communityIdNo);
            return ResponseEntity.ok(business);
        }
    }


