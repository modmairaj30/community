package com.ve.community.services;

import com.ve.community.models.LifePartnerProfile;
import com.ve.community.models.Users;
import com.ve.community.payloads.request.LifePartnerProfileRequest;
import com.ve.community.payloads.request.UsersRequest;
import com.ve.community.payloads.response.LifePartnerProfileResponse;
import com.ve.community.payloads.response.UsersResponse;

import java.util.List;

public interface LifePartnerProfileService {
    List<LifePartnerProfileResponse> getAllProfiles();
    //User getUserById(Integer id);
    LifePartnerProfile createProfile(LifePartnerProfileRequest lifePartnerProfileRequest);
	LifePartnerProfile getUserById(Integer communityIdNo);
}
