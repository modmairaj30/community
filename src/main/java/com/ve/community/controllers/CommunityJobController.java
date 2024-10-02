package com.ve.community.controllers;

import com.ve.community.constants.CommonConstant;
import com.ve.community.constants.ResponseWrapper;
import com.ve.community.payloads.request.CommunityBusinessRequest;
import com.ve.community.payloads.request.CommunityJobRequest;
import com.ve.community.payloads.response.CommunityBusinessResponse;
import com.ve.community.payloads.response.CommunityJobResponse;
import com.ve.community.services.CommunityBusinessService;
import com.ve.community.services.CommunityJobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
}