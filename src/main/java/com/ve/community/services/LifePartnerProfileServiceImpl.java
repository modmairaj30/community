package com.ve.community.services;

import java.util.List;
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
}
