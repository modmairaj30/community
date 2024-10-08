package com.ve.community.services;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ve.community.models.Advertisement;
import com.ve.community.models.CommunityBusiness;
import com.ve.community.payloads.request.AdvertisementRequest;

import com.ve.community.payloads.response.AdvertisementResponse;
import com.ve.community.payloads.response.CommunityBusinessResponse;
import com.ve.community.repository.AdvertisementRepository;


import jakarta.transaction.Transactional;
@Service
public class AdvertisementServiceImpl implements AdvertisementService {
	 @Autowired
	    private ModelMapper modelMapper;

	    @Autowired
	    private AdvertisementRepository advertisementRepository;

		@Transactional
		public Advertisement createAdvertisement(AdvertisementRequest advertisementRequest) {
			 Advertisement advertisement = modelMapper.map(advertisementRequest, Advertisement.class);
		        return advertisementRepository.save(advertisement);
			
		}

		@Override
		public List<AdvertisementResponse> getAdvertisement() {
			List<Advertisement> list_community = advertisementRepository.findAll();
			List<AdvertisementResponse> list_adv=list_community.stream()
	           
	                .map(advertisement -> modelMapper.map(advertisement, AdvertisementResponse.class))
	                .collect(Collectors.toList());
	        return list_adv;
			
		}

		@Override
		public Advertisement getById(Integer id) {
			return advertisementRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("advertisement not found for ID: " + id));
		
			
		}

	    

} 