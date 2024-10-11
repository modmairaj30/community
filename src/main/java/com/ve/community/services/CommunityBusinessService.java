package com.ve.community.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ve.community.models.CommunityBusiness;
import com.ve.community.payloads.request.CommunityBusinessRequest;
import com.ve.community.payloads.response.CommunityBusinessResponse;

@Service
public interface CommunityBusinessService {
	CommunityBusiness createCommunity(CommunityBusinessRequest communityBusinessRequest);

	List<CommunityBusinessResponse> getCommunity();

	CommunityBusiness getBusinessById(Integer communityIdNo);

	String saveAll(List<CommunityBusinessResponse> communityBusinessResponse);
}
