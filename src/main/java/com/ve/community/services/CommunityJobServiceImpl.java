package com.ve.community.services;



import com.ve.community.models.CommunityJob;
import com.ve.community.payloads.request.CommunityJobRequest;
import com.ve.community.payloads.response.CommunityJobResponse;
import com.ve.community.repository.CommunityJobRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityJobServiceImpl implements CommunityJobService{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CommunityJobRepository communityJobRepository;

    @Transactional
    public CommunityJob createJob(CommunityJobRequest communityJobRequest){
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

}
