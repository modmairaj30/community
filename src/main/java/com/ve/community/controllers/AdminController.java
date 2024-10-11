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
import com.ve.community.models.Admin;
import com.ve.community.payloads.request.AdminRequest;
import com.ve.community.payloads.request.ListOfActivateRequest;
import com.ve.community.payloads.response.AdminResponse;
import com.ve.community.services.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AdminController {
	@Autowired
    AdminService adminService;
    @GetMapping("/getAllAdmin")
    public ResponseWrapper<List<AdminResponse>> getAllAdmin(){
        List<AdminResponse> profilesList=adminService.getAllAdmin();
        return new ResponseWrapper(HttpStatus.OK,"",profilesList);
    }

    @PostMapping("/saveAdmin")
    public ResponseEntity<String> createAdmin(@Valid @RequestBody AdminRequest adminRequest) {
        adminService.createAdmin(adminRequest);
        return ResponseEntity.ok(CommonConstant.ADMIN_SUCCESSFULLY);
    }
 // 3. Get a profile by communityIdNo
    @GetMapping("/admin/{id}")
    public ResponseEntity<Admin> getById(@PathVariable Integer id) {
       Admin adv = adminService.getById(id);
        return new ResponseEntity<>(adv, HttpStatus.OK);
    }
    
    @GetMapping("/getAllStatus")
    public ResponseWrapper<ListOfActivateRequest> getAllStatus(){
        ListOfActivateRequest listOfActivateRequest =  adminService.getAllStatus();
        return new ResponseWrapper<ListOfActivateRequest>(HttpStatus.OK,"",listOfActivateRequest);
    }
    
    @PostMapping("/saveAllStatus")
    public ResponseWrapper<ListOfActivateRequest> saveAllStatus(@RequestBody ListOfActivateRequest listOfActivateRequest){
        String save =  adminService.saveAllStatus(listOfActivateRequest);
        return new ResponseWrapper<ListOfActivateRequest>(HttpStatus.OK,"Data Saved Successfully",null);
    }

}
