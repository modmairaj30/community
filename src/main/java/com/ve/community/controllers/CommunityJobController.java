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
}