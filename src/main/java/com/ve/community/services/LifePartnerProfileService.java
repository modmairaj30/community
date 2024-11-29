package com.ve.community.services;

import java.util.List;

import com.ve.community.models.LifePartnerProfile;
import com.ve.community.payloads.request.LifePartnerProfileRequest;
import com.ve.community.payloads.response.LifePartnerProfileResponse;

public interface LifePartnerProfileService {
	List<LifePartnerProfileResponse> getAllProfiles();

	// User getUserById(Integer id);
	LifePartnerProfile createProfile(LifePartnerProfileRequest lifePartnerProfileRequest);

	LifePartnerProfile getUserById(Integer communityIdNo);

	String saveAll(List<LifePartnerProfileResponse> lifePartnerProfileResponse);
	void deleteProfile(Integer communityIdNo);
	void updateProfile(Integer communityIdNo, LifePartnerProfileRequest lifePartnerProfileRequest);
	  void updateProfileStatus(Integer communityIdNo, String statusType, String statusValue);

}
