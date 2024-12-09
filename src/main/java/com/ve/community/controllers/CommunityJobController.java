package com.ve.community.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;

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
    @Autowired
    ModelMapper modelMapper;
    @GetMapping("/getAllJobs")
    public ResponseWrapper<List<CommunityJobResponse>> getAllJobs(){
        List<CommunityJobResponse> profilesList=communityJobService.getJob();
        return new ResponseWrapper(HttpStatus.OK,"JobDetails fetched successfully",true,profilesList);
    }

    @PostMapping("/saveJob")
    public ResponseWrapper<Boolean> createJob(@Valid @RequestBody CommunityJobRequest communityJobRequest) {
        communityJobService.createJob(communityJobRequest);
        return new ResponseWrapper<>(HttpStatus.OK,CommonConstant.JOB_SUCCESSFULLY,true);
    }
    
    @GetMapping("/jobDetailsGetById/{communityIdNo}")
    public ResponseWrapper<CommunityJobResponse> getJobById(@PathVariable Integer communityIdNo) {
        CommunityJob communityJob =communityJobService.getJobById(communityIdNo);
        CommunityJobResponse communityJobResponse = modelMapper.map(communityJob,CommunityJobResponse.class);
        return new ResponseWrapper<>(HttpStatus.OK,"Job Details  fetched successfully",true,communityJobResponse);
    }

    @PutMapping("/updateJob")
    public ResponseWrapper<Boolean> updateCommunityJob(@Valid @RequestBody CommunityJobRequest communityJobRequest){
       CommunityJob job= communityJobService.updateJob(communityJobRequest);
        return new ResponseWrapper<>(HttpStatus.OK,CommonConstant.JOB_UPDATED_SUCCESSFULLY,true);
    }

    @DeleteMapping("/deleteJob/{communityIdNo}")
    public  ResponseWrapper<Boolean> deleteCommuntyJob(@PathVariable Integer communityIdNo){

        communityJobService.deleteJob(communityIdNo);

        return  new ResponseWrapper<>(HttpStatus.OK,CommonConstant.JOB_DELETED_SUCCESSFULLY,true);

    }




    @PutMapping("/admin/updateJobStatus/{communityIdNo}")
    public ResponseWrapper<Boolean> updateCommuniyuJobStatus(@PathVariable Integer communityIdNo, @RequestParam String statusType) {

            communityJobService.updateJobStatus(communityIdNo, statusType);
            return new ResponseWrapper<>(HttpStatus.OK,"communityJob status updated successfully",true);



    }




    }
