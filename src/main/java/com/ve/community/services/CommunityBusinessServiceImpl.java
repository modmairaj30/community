package com.ve.community.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ve.community.models.CommunityBusiness;
import com.ve.community.payloads.request.CommunityBusinessRequest;
import com.ve.community.payloads.response.CommunityBusinessResponse;
import com.ve.community.repository.CommunityBusinessRepository;

import jakarta.transaction.Transactional;

@Service
public class CommunityBusinessServiceImpl implements CommunityBusinessService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CommunityBusinessRepository communityBusinessRepository;

	@Transactional
	public CommunityBusiness createCommunity(CommunityBusinessRequest communityBusinessRequest) {
		CommunityBusiness communityBusiness = modelMapper.map(communityBusinessRequest, CommunityBusiness.class);
		return communityBusinessRepository.save(communityBusiness);
	}

	@Override
	public List<CommunityBusinessResponse> getCommunity() {
		List<CommunityBusiness> list_community = communityBusinessRepository.findAll();
		List<CommunityBusinessResponse> lis_com = list_community.stream()
				.map(communityBusiness -> modelMapper.map(communityBusiness, CommunityBusinessResponse.class))
				.collect(Collectors.toList());
		return lis_com;
	}

	@Override
	public CommunityBusiness getBusinessById(Integer communityIdNo) {
		return communityBusinessRepository.findById(communityIdNo)
				.orElseThrow(() -> new RuntimeException("Business not found"));
	}

	@Override
	public String saveAll(List<CommunityBusinessResponse> communityBusinessResponse) {
		List<CommunityBusiness> list  = communityBusinessResponse.stream().map(obj -> modelMapper.map(obj, CommunityBusiness.class))
				.collect(Collectors.toList());
		list.stream().map(obj -> communityBusinessRepository.save(obj));
		 
		return "Successfully Saved";
	}

}
