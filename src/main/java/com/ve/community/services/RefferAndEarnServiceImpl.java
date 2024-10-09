package com.ve.community.services;



import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ve.community.models.RefferAndEarn;
import com.ve.community.payloads.request.RefferAndEarnRequest;
import com.ve.community.payloads.response.RefferAndEarnResponse;
import com.ve.community.repository.RefferAndEarnRepository;

@Service
public class RefferAndEarnServiceImpl implements RefferAndEarnService{
	
	 @Autowired
	 private ModelMapper modelMapper;
	 
	@Autowired
	private RefferAndEarnRepository refferAndEarnRepository;
	
	@Override
	public List<RefferAndEarnResponse> getAllRefferals() {
		List<RefferAndEarn>list_refferal = refferAndEarnRepository.findAll();
		List<RefferAndEarnResponse> list_reff = list_refferal.stream()
				.map(refferAndEarn -> modelMapper.map(refferAndEarn, RefferAndEarnResponse.class))
				.collect(Collectors.toList());
		return list_reff;
	}
	
			
	@Override
	public RefferAndEarn createReferral(RefferAndEarnRequest refferAndEarnRequest) {
		RefferAndEarn reffer = modelMapper.map(refferAndEarnRequest, RefferAndEarn.class);
		return refferAndEarnRepository.save(reffer);
	}
	


	@Override
    public RefferAndEarn getReferralById(Integer id) {
        return refferAndEarnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Referral not found"));
    }
	
}
