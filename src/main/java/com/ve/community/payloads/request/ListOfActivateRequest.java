package com.ve.community.payloads.request;

import java.util.List;

import com.ve.community.payloads.response.AdvertisementResponse;
import com.ve.community.payloads.response.CommunityBusinessResponse;
import com.ve.community.payloads.response.CommunityJobResponse;
import com.ve.community.payloads.response.LifePartnerProfileResponse;

import lombok.Data;

@Data
public class ListOfActivateRequest {
	// List<Users> usersList;
	List<CommunityJobResponse> communityJobResponse;
	List<CommunityBusinessResponse> communityBusinessResponse;
	List<AdvertisementResponse> advertisementResponse;
	List<LifePartnerProfileResponse> lifePartnerProfileResponse;

}
