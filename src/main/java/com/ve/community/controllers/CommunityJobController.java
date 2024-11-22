package com.ve.community.controllers;

import java.util.List;

import com.ve.community.constants.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.ve.community.constants.ResponseWrapper;
import com.ve.community.models.CommunityJob;
import com.ve.community.payloads.request.CommunityJobRequest;
import com.ve.community.payloads.response.CommunityJobResponse;
import com.ve.community.services.CommunityJobService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/auth")
public class CommunityJobController {
    @Autowired
    CommunityJobService communityJobService;
    @GetMapping("/getAllJobs")
    public ResponseWrapper<List<CommunityJobResponse>> getAllJobs(){
        List<CommunityJobResponse> profilesList=communityJobService.getJob();
        return new ResponseWrapper(HttpStatus.OK,"",profilesList);
    }

    @PostMapping("/saveJob")
    public ResponseEntity<String> createJob(@Valid @RequestBody CommunityJobRequest communityJobRequest) {
        communityJobService.createJob(communityJobRequest);
        return ResponseEntity.ok(CommonConstant.JOB_SUCCESSFULLY);
    }
    
    @GetMapping("/job/{communityIdNo}")
    public ResponseEntity<CommunityJob> getJobById(@PathVariable Integer communityIdNo) {
        CommunityJob job = communityJobService.getJobById(communityIdNo);
        return ResponseEntity.ok(job);
    }

    @PutMapping("/updateJob/{communityIdNo}")
    public ResponseEntity<String> updateCommunityJob(@PathVariable Integer communityIdNo,@RequestBody CommunityJobRequest communityJobRequest){
       CommunityJob job= communityJobService.updateJob(communityIdNo,communityJobRequest);
        return ResponseEntity.ok(CommonConstant.JOB_UPDATED_SUCCESSFULLY);
    }

    @DeleteMapping("/deleteJob/{communityIdNo}")
    public  ResponseEntity<String> deleteCommuntyJob(@PathVariable Integer communityIdNo){

        communityJobService.deleteJob(communityIdNo);

        return  ResponseEntity.ok(CommonConstant.JOB_DELETED_SUCCESSFULLY);

    }

    }
