package com.ve.community.services;

import java.util.List;

import com.ve.community.models.CommunityJob;
import com.ve.community.payloads.request.CommunityJobRequest;
import com.ve.community.payloads.response.CommunityJobResponse;

public interface CommunityJobService {

	CommunityJob createJob(CommunityJobRequest communityBusinessRequest);

	List<CommunityJobResponse> getJob();

	CommunityJob getJobById(Integer communityIdNo);

	String saveAll(List<CommunityJobResponse> communityJobResponse);

	CommunityJob updateJob(CommunityJobRequest communityJobRequest);

	void deleteJob(Integer communityIdNo);



	public CommunityJob updateJobStatus(Integer communityIdNo, String statusType);

}
