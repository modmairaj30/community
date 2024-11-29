package com.ve.community.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ve.community.models.LifePartnerProfile;
import com.ve.community.payloads.request.LifePartnerProfileRequest;
import com.ve.community.payloads.response.LifePartnerProfileResponse;
import com.ve.community.repository.LifePartnerProfileRepository;

@Service
public class LifePartnerProfileServiceImpl implements LifePartnerProfileService {

	@Autowired
	private LifePartnerProfileRepository lifePartnerProfileRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<LifePartnerProfileResponse> getAllProfiles() {
		List<LifePartnerProfile> list_profile = lifePartnerProfileRepository.findAll();

		List<LifePartnerProfileResponse> list_res = list_profile.stream()
				.map(profile -> modelMapper.map(profile, LifePartnerProfileResponse.class))
				.collect(Collectors.toList());
		return list_res;

	}

	@Override
	public LifePartnerProfile createProfile(LifePartnerProfileRequest lifePartnerProfileRequest) {
		LifePartnerProfile profile = modelMapper.map(lifePartnerProfileRequest, LifePartnerProfile.class);
		return lifePartnerProfileRepository.save(profile);
	}

	@Override
	public LifePartnerProfile getUserById(Integer communityIdNo) {
		return lifePartnerProfileRepository.findById(communityIdNo)
				.orElseThrow(() -> new RuntimeException("Profile not found for ID: " + communityIdNo));

	}

	@Override
	public String saveAll(List<LifePartnerProfileResponse> lifePartnerProfileResponse) {
		List<LifePartnerProfile> list = lifePartnerProfileResponse.stream()
				.map(obj -> modelMapper.map(obj, LifePartnerProfile.class)).collect(Collectors.toList());
		// list.stream().map(obj -> lifePartnerProfileRepository.saveAndFlush(obj));
		for (int i = 0; i < list.size(); i++) {
			lifePartnerProfileRepository.saveAndFlush(list.get(i));
		}

		return "Successfully Saved";
	}

//	@Override
//	public void deleteProfile(Integer communityIdNo) {
//		LifePartnerProfile existingProfile = lifePartnerProfileRepository.findById(communityIdNo)
//		        .orElseThrow(() -> new RuntimeException("LifePartnerProfile not found with id: " + communityIdNo));
//		    
//		    lifePartnerProfileRepository.delete(existingProfile);
//		
//	}

	@Override
	public void updateProfile(Integer communityIdNo, LifePartnerProfileRequest lifePartnerProfileRequest) {
		LifePartnerProfile existingProfile = lifePartnerProfileRepository.findById(communityIdNo)
		        .orElseThrow(() -> new RuntimeException("LifePartnerProfile not found with id: " + communityIdNo));
		    
		    // Use ModelMapper to map updated fields from the request to the existing entity
		    modelMapper.map(lifePartnerProfileRequest, existingProfile);

		    // Save the updated entity
		    lifePartnerProfileRepository.save(existingProfile);
		
	}
	
	public void deleteProfile(Integer communityIdNo) {
        // Fetch the profile by communityIdNo
        Optional<LifePartnerProfile> optionalProfile = lifePartnerProfileRepository.findByCommunityIdNoAndDeletedFalse(communityIdNo);

        if (optionalProfile.isPresent()) {
            LifePartnerProfile profile = optionalProfile.get();
            profile.setDeleted(true); // Mark as deleted
            lifePartnerProfileRepository.save(profile); // Save the updated profile
        } else {
            throw new RuntimeException("Profile not found or already deleted for Community ID: " + communityIdNo);
        }}

	
	@Override
	public void updateProfileStatus(Integer communityIdNo, String statusType, String statusValue) {
	    Optional<LifePartnerProfile> optionalProfile = lifePartnerProfileRepository.findById(communityIdNo);
	    
	    if (optionalProfile.isEmpty()) {
	        throw new IllegalArgumentException("Profile with ID " + communityIdNo + " not found.");
	    }

	    LifePartnerProfile profile = optionalProfile.get();
	    
	    if ("profileStatus".equalsIgnoreCase(statusType)) {
	        // Validate the statusValue
	        if (!Arrays.asList("approved", "pending", "rejected").contains(statusValue.toLowerCase())) {
	            throw new IllegalArgumentException("Invalid status value: " + statusValue);
	        }
	        profile.setProfileStatus(statusValue);
	    } else {
	        throw new IllegalArgumentException("Invalid status type for profile: " + statusType);
	    }

	    lifePartnerProfileRepository.save(profile);
	}

	/*public void updateProfileStatus(Integer communityIdNo, String statusType, String statusValue) {
		Optional<LifePartnerProfile> optionalProfile = lifePartnerProfileRepository.findById(communityIdNo);
        if (optionalProfile.isEmpty()) {
            throw new IllegalArgumentException("Profile with ID " + communityIdNo + " not found.");
        }

        LifePartnerProfile profile = optionalProfile.get();
        if ("profileStatus".equalsIgnoreCase(statusType)) {
            profile.setProfileStatus(statusValue);
        } else {
            throw new IllegalArgumentException("Invalid status type for profile: " + statusType);
        }

      lifePartnerProfileRepository.save(profile);
    }*/
		
	}

