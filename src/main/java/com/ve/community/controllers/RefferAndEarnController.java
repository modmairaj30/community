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
import com.ve.community.models.RefferAndEarn;
import com.ve.community.payloads.request.RefferAndEarnRequest;
import com.ve.community.payloads.response.RefferAndEarnResponse;
import com.ve.community.services.RefferAndEarnService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/auth")
public class RefferAndEarnController {

	@Autowired
	private RefferAndEarnService refferAndEarnService;
	
	@GetMapping("/getAllRefferals")
    public ResponseWrapper<List<RefferAndEarnResponse>> getAllRefferals(){
		List<RefferAndEarnResponse> refferList=  refferAndEarnService.getAllRefferals();
        return new ResponseWrapper(HttpStatus.OK,"",refferList);
    }

	

    @PostMapping("/saveRefferal")
    public ResponseEntity<String> createRefferal(@Valid @RequestBody RefferAndEarnRequest refferAndEarnRequest) {
    	refferAndEarnService.createReferral(refferAndEarnRequest);
    	return  ResponseEntity.ok(CommonConstant.REFFERANDEARN_SUCCESSFULLY);
    }
    

	
    @GetMapping("/{id}")
    public ResponseEntity<RefferAndEarn> getReferralById(@PathVariable Integer id) {
        RefferAndEarn referral = refferAndEarnService.getReferralById(id);
        return ResponseEntity.ok(referral);
    }
   
}
