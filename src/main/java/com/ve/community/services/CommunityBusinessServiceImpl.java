package com.ve.community.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ve.community.models.CommunityBusiness;
import com.ve.community.models.LifePartnerProfile;
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
		List<CommunityBusiness> list = communityBusinessResponse.stream()
				.map(obj -> modelMapper.map(obj, CommunityBusiness.class)).collect(Collectors.toList());

		for (int i = 0; i < list.size(); i++) {
			communityBusinessRepository.saveAndFlush(list.get(i));
		}

		return "Successfully Saved";
	}

	@Override
	public void deleteBusiness(Integer communityIdNo) {
		Optional<CommunityBusiness> optionalBusiness = communityBusinessRepository.findByCommunityIdNoAndDeletedFalse(communityIdNo);

        if (optionalBusiness.isPresent()) {
            CommunityBusiness business = optionalBusiness.get();
           business.setDeleted(true); // Mark as deleted
            communityBusinessRepository.save(business); // Save the updated profile
        } else {
            throw new RuntimeException("Business not found or already deleted for Community ID: " + communityIdNo);}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBuisness(Integer communityIdNo, CommunityBusinessRequest communityBusinessRequest) {
		// TODO Auto-generated method stub
		CommunityBusiness existingbusiness = communityBusinessRepository.findById(communityIdNo)
		        .orElseThrow(() -> new RuntimeException("CommunityBusiness not found with id: " + communityIdNo));
		    
		    // Use ModelMapper to map updated fields from the request to the existing entity
		    modelMapper.map(communityBusinessRequest, existingbusiness);

		    // Save the updated entity
		   communityBusinessRepository.save(existingbusiness);
	}

	@Override
	public void updateBusinessStatus(Integer communityIdNo, String statusType, String statusValue) {
Optional<CommunityBusiness> optionalBusiness = communityBusinessRepository.findById(communityIdNo);
	    
	    if (optionalBusiness.isEmpty()) {
	        throw new IllegalArgumentException("Business with ID " + communityIdNo + " not found.");
	    }

	    CommunityBusiness business = optionalBusiness.get();
	    
	    if ("businessStatus".equalsIgnoreCase(statusType)) {
	        // Validate the statusValue
	        if (!Arrays.asList("approved", "pending", "rejected").contains(statusValue.toLowerCase())) {
	            throw new IllegalArgumentException("Invalid status value: " + statusValue);
	        }
	        business.setBusinessStatus(statusValue);
	    } else {
	        throw new IllegalArgumentException("Invalid status type for profile: " + statusType);
	    }

	    communityBusinessRepository.save(business);
		
	}

}
