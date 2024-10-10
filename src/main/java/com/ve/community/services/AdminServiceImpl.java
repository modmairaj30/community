package com.ve.community.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ve.community.models.Admin;
import com.ve.community.models.Advertisement;
import com.ve.community.payloads.request.AdminRequest;
import com.ve.community.payloads.response.AdminResponse;
import com.ve.community.payloads.response.AdvertisementResponse;
import com.ve.community.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	 @Autowired
	    private ModelMapper modelMapper;

	    @Autowired
	    private AdminRepository adminRepository;
	@Override
	public Admin createAdmin(AdminRequest adminRequest) {
		Admin admin = modelMapper.map(adminRequest, Admin.class);
        return adminRepository.save(admin);
		
	}

	@Override
	public Admin getById(Integer id) {
		return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("admin not found for ID: " + id));
		
		
	}

	@Override
	public List<AdminResponse> getAllAdmin() {
		List<Admin> list_community = adminRepository.findAll();
		List<AdminResponse> list_adv=list_community.stream()
           
                .map(admin -> modelMapper.map(admin, AdminResponse.class))
                .collect(Collectors.toList());
        return list_adv;
		
		
	}

}
