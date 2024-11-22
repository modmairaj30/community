package com.ve.community.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ve.community.models.CommunityJob;
import com.ve.community.payloads.request.CommunityJobRequest;
import com.ve.community.payloads.response.CommunityJobResponse;
import com.ve.community.repository.CommunityJobRepository;

import jakarta.transaction.Transactional;

@Service
public class CommunityJobServiceImpl implements CommunityJobService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CommunityJobRepository communityJobRepository;

	@Transactional
	public CommunityJob createJob(CommunityJobRequest communityJobRequest) {
		CommunityJob communityJob = modelMapper.map(communityJobRequest, CommunityJob.class);
		return communityJobRepository.save(communityJob);
	}

	@Override
	public List<CommunityJobResponse> getJob() {
		List<CommunityJob> list_cjob = communityJobRepository.findAll();
		List<CommunityJobResponse> lis_job = list_cjob.stream()
				.map(communityJob -> modelMapper.map(communityJob, CommunityJobResponse.class))
				.collect(Collectors.toList());
		return lis_job;
	}

	@Override
	public CommunityJob getJobById(Integer communityIdNo) {
		return communityJobRepository.findById(communityIdNo).orElseThrow(() -> new RuntimeException("Job not found"));
	}

	@Override
	public String saveAll(List<CommunityJobResponse> communityJobResponse) {
		List<CommunityJob> list = communityJobResponse.stream().map(obj -> modelMapper.map(obj, CommunityJob.class))
				.collect(Collectors.toList());
		//list.stream().map(obj -> communityJobRepository.saveAndFlush(obj));
		for (int i = 0; i < list.size(); i++) {
			communityJobRepository.saveAndFlush(list.get(i));
		}

		return "Successfully Saved";
	}

	@Override
	public CommunityJob updateJob(Integer communityIdNo, CommunityJobRequest communityJobRequest) {

		//CommunityJob CommunityJob ;
		CommunityJob existingCommunityJob= communityJobRepository.findById(communityIdNo).orElseThrow(() ->new RuntimeException("communityJob not " +
				"found with id"+communityIdNo));



		modelMapper.map(communityJobRequest,existingCommunityJob);

        return communityJobRepository.save(existingCommunityJob);

		//	return communityJobRepository.save(existingcommunityJob);


	}

	@Override
	public void deleteJob(Integer communityIdNo) {

		CommunityJob existingJobCommunity = communityJobRepository.findById(communityIdNo).orElseThrow(() -> new RuntimeException("JobCommunity not found communityId"+communityIdNo));

		 communityJobRepository.delete(existingJobCommunity);

	}


}
