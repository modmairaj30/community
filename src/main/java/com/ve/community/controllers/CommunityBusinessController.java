package com.ve.community.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ve.community.constants.CommonConstant;
import com.ve.community.constants.ResponseWrapper;
import com.ve.community.models.CommunityBusiness;
import com.ve.community.models.LifePartnerProfile;
import com.ve.community.payloads.request.CommunityBusinessRequest;
import com.ve.community.payloads.request.LifePartnerProfileRequest;
import com.ve.community.payloads.response.CommunityBusinessResponse;
import com.ve.community.payloads.response.LifePartnerProfileResponse;
import com.ve.community.services.CommunityBusinessService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/auth")
public class CommunityBusinessController {
    @Autowired
        CommunityBusinessService communityBusinessService;
    @Autowired
    private ModelMapper modelMapper;
        @GetMapping("/getAllBusiness")
        public ResponseWrapper<List<CommunityBusinessResponse>> getAllBusiness(){
            List<CommunityBusinessResponse> businessList=communityBusinessService.getCommunity();
            return new ResponseWrapper<>(HttpStatus.OK, "Business fetched successfully", true, businessList);
            
        }

        @PostMapping("/saveBusiness")
        public ResponseEntity<String> createBusiness(@Valid @RequestBody CommunityBusinessRequest communityBusinessRequest) {
            communityBusinessService.createCommunity(communityBusinessRequest);
            return ResponseEntity.ok(CommonConstant.BUSINESS_SUCCESSFULLY);
        }
        
        @GetMapping("/bussiness/{communityIdNo}")
        public ResponseWrapper<CommunityBusinessResponse> getBusinessById(@PathVariable Integer communityIdNo) {
           // CommunityBusiness business = communityBusinessService.getBusinessById(communityIdNo);
           // return ResponseEntity.ok(business);
        CommunityBusiness business = communityBusinessService.getBusinessById(communityIdNo);

            // Use ModelMapper to map the entity to the response DTO
           CommunityBusinessResponse response = modelMapper.map(business, CommunityBusinessResponse.class);

            return new ResponseWrapper<>(HttpStatus.OK, "Business fetched successfully", true, response);
        }
        @DeleteMapping("/deleteBusiness/{communityIdNo}")
        public ResponseWrapper<Void> deleteBusiness(@PathVariable Integer communityIdNo) {
            communityBusinessService.deleteBusiness(communityIdNo);
            return new ResponseWrapper<>(HttpStatus.OK, CommonConstant.BUSINESS_DELETED_SUCCESSFULLY, true);
        }

        @PutMapping("/updateCommunityBusiness/{communityIdNo}")
        public ResponseWrapper<Void> updateBusiness(
                @PathVariable Integer communityIdNo,
                @Valid @RequestBody CommunityBusinessRequest communityBusinessRequest) {
            communityBusinessService.updateBuisness(communityIdNo, communityBusinessRequest);
            return new ResponseWrapper<>(HttpStatus.OK, CommonConstant.BUSINESS_UPDATED_SUCCESSFULLY, true);
        }

        @PatchMapping("/updateBusinessStatus/{communityIdNo}")
        public ResponseWrapper<Void> updateBusinessStatus(
                @PathVariable Integer communityIdNo,
                @RequestParam String statusType,
                @RequestParam String statusValue) {
            communityBusinessService.updateBusinessStatus(communityIdNo, statusType, statusValue);
            return new ResponseWrapper<>(HttpStatus.OK, "Profile status updated successfully", true);
        }
}


