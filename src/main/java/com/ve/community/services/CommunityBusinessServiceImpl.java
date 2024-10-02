package com.ve.community.services;




import com.ve.community.models.CommunityBusiness;
import com.ve.community.payloads.request.CommunityBusinessRequest;
import com.ve.community.payloads.response.CommunityBusinessResponse;
import com.ve.community.repository.CommunityBusinessRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommunityBusinessServiceImpl implements CommunityBusinessService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommunityBusinessRepository communityBusinessRepository;

    @Transactional
    public CommunityBusiness createCommunity(CommunityBusinessRequest communityBusinessRequest){
        CommunityBusiness communityBusiness = modelMapper.map(communityBusinessRequest, CommunityBusiness.class);
        return communityBusinessRepository.save(communityBusiness);
    }

    @Override
    public List<CommunityBusinessResponse> getCommunity() {
        List<CommunityBusiness> list_community = communityBusinessRepository.findAll();
        List<CommunityBusinessResponse> lis_com = list_community.stream()
                .map(communityBusiness -> modelMapper.map(communityBusiness, CommunityBusinessResponse.class))
                .collect(Collectors.toList());
        return lis_com;
    }

}

