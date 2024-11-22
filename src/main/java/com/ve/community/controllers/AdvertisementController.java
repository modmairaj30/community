package com.ve.community.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ve.community.constants.CommonConstant;
import com.ve.community.constants.ResponseWrapper;
import com.ve.community.models.Advertisement;
import com.ve.community.payloads.request.AdvertisementRequest;
import com.ve.community.payloads.response.AdvertisementResponse;
import com.ve.community.services.AdvertisementService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AdvertisementController {
	 @Autowired
     AdvertisementService advertisementService;
	 
	
     @GetMapping("/getAllAdvertisements")
     public ResponseWrapper<List<AdvertisementResponse>> getAllAdvertisements(){
         List<AdvertisementResponse> profilesList=advertisementService.getAdvertisement();
         return new ResponseWrapper(HttpStatus.OK,"",profilesList);
     }

     @PostMapping("/saveAdvertisement")
     public ResponseEntity<String> createAdvertisement(@Valid @RequestBody AdvertisementRequest advertisementRequest) {
         advertisementService.createAdvertisement(advertisementRequest);
         return ResponseEntity.ok(CommonConstant.ADVERTISEMENT_SUCCESSFULLY);
     }
  // 3. Get a profile by communityIdNo
     @GetMapping("/advertisement/{id}")
     public ResponseEntity<Advertisement> getById(@PathVariable Integer id) {
        Advertisement adv = advertisementService.getById(id);
         return new ResponseEntity<>(adv, HttpStatus.OK);
     }
     @DeleteMapping("/deleteAdvertisement/{id}")
     public ResponseEntity<String> deleteProfile(@PathVariable Integer id) {
         advertisementService.deleteAdvertisement(id);
         return ResponseEntity.ok(CommonConstant.ADVERTISEMENT_DELETED_SUCCESSFULLY);
     }
     @PutMapping("/updateAdvertisement/{id}")
     public ResponseEntity<String> updateProfile(@PathVariable Integer id, 
                                                 @Valid @RequestBody AdvertisementRequest advertisementRequest) {
         advertisementService.updateProfile(id, advertisementRequest);
         return ResponseEntity.ok(CommonConstant.ADVERTISEMENT_UPDATED_SUCCESSFULLY);
     }

}