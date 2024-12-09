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
import com.ve.community.models.Advertisement;
import com.ve.community.models.LifePartnerProfile;
import com.ve.community.payloads.request.AdvertisementRequest;
import com.ve.community.payloads.response.AdvertisementResponse;
import com.ve.community.payloads.response.LifePartnerProfileResponse;
import com.ve.community.services.AdvertisementService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AdvertisementController {
	 @Autowired
     AdvertisementService advertisementService;
	 @Autowired
	    private ModelMapper modelMapper;
	 
	
     @GetMapping("/getAllAdvertisements")
     public ResponseWrapper<List<AdvertisementResponse>> getAllAdvertisements(){
         List<AdvertisementResponse> advList=advertisementService.getAdvertisement();
         return new ResponseWrapper<>(HttpStatus.OK, "Advertisement fetched successfully", true, advList);
      //   return new ResponseWrapper(HttpStatus.OK,"",profilesList);
     }

     @PostMapping("/saveAdvertisement")
     public ResponseEntity<String> createAdvertisement(@Valid @RequestBody AdvertisementRequest advertisementRequest) {
         advertisementService.createAdvertisement(advertisementRequest);
         return ResponseEntity.ok(CommonConstant.ADVERTISEMENT_SUCCESSFULLY);
     }
  // 3. Get a profile by communityIdNo
   //  @GetMapping("/advertisement/{id}")
   //  public ResponseEntity<Advertisement> getById(@PathVariable Integer id) {
    //    Advertisement adv = advertisementService.getById(id);
    //     return new ResponseEntity<>(adv, HttpStatus.OK);
   //  }
     @GetMapping("/advertisement/{id}")
     public ResponseWrapper<AdvertisementResponse> getProfileById(@PathVariable Integer id) {
         Advertisement ad = advertisementService.getById(id);

         // Use ModelMapper to map the entity to the response DTO
         AdvertisementResponse response = modelMapper.map(ad, AdvertisementResponse.class);

         return new ResponseWrapper<>(HttpStatus.OK, "Profile fetched successfully", true, response);
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
     @PatchMapping("/updateAdvertisementStatus/{id}")
     public ResponseEntity<String> updateAdvertisementStatus(
             @PathVariable Integer id,
             @RequestParam String statusType,
             @RequestParam String statusValue) {

         advertisementService.updateAdvertisementStatus(id, statusType, statusValue);
         return ResponseEntity.ok("Advertisement status updated successfully for ID:");
     }

}