package com.ve.community.services;

import java.util.List;

import com.ve.community.models.Advertisement;
import com.ve.community.payloads.request.AdvertisementRequest;
import com.ve.community.payloads.response.AdvertisementResponse;

public interface AdvertisementService {
	Advertisement createAdvertisement(AdvertisementRequest advertisementRequest);

	Advertisement getById(Integer id);

	List<AdvertisementResponse> getAdvertisement();
	
	String saveAll(List<AdvertisementResponse> advertisementRequest);
	void updateProfile(Integer id, AdvertisementRequest advertisementRequest);
	void deleteAdvertisement(Integer id);

}