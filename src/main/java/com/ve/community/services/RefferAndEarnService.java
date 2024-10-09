package com.ve.community.services;

import java.util.List;

import com.ve.community.models.RefferAndEarn;
import com.ve.community.payloads.request.RefferAndEarnRequest;
import com.ve.community.payloads.response.RefferAndEarnResponse;

import jakarta.validation.Valid;

public interface RefferAndEarnService {

	List<RefferAndEarnResponse> getAllRefferals();

	RefferAndEarn createReferral(RefferAndEarnRequest refferAndEarnRequest);
	
	RefferAndEarn getReferralById(Integer id);



}
