package com.ve.community.services;




import com.ve.community.models.CommunityBusiness;
import com.ve.community.payloads.request.CommunityBusinessRequest;
import com.ve.community.payloads.response.CommunityBusinessResponse;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommunityBusinessService  {
    CommunityBusiness createCommunity(CommunityBusinessRequest communityBusinessRequest);

    List<CommunityBusinessResponse> getCommunity();


}
