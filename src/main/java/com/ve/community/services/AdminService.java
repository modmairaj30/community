package com.ve.community.services;

import java.util.List;

import com.ve.community.models.Admin;
import com.ve.community.payloads.request.AdminRequest;
import com.ve.community.payloads.response.AdminResponse;


public interface AdminService {
	Admin createAdmin(AdminRequest adminRequest);
	 Admin getById(Integer id);
	    List<AdminResponse> getAllAdmin();

}
