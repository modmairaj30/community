package com.ve.community.services;




import com.ve.community.models.CommunityJob;
import com.ve.community.payloads.request.CommunityJobRequest;
import com.ve.community.payloads.response.CommunityBusinessResponse;
import com.ve.community.payloads.response.CommunityJobResponse;

import java.util.List;

public interface CommunityJobService {

    CommunityJob createJob(CommunityJobRequest communityBusinessRequest);

    List<CommunityJobResponse> getJob();
    
    CommunityJob getJobById(Integer communityIdNo);
}
