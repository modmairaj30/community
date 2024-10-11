package com.ve.community.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ve.community.models.Admin;
import com.ve.community.payloads.request.AdminRequest;
import com.ve.community.payloads.request.ListOfActivateRequest;
import com.ve.community.payloads.response.AdminResponse;
import com.ve.community.payloads.response.AdvertisementResponse;
import com.ve.community.payloads.response.CommunityBusinessResponse;
import com.ve.community.payloads.response.CommunityJobResponse;
import com.ve.community.payloads.response.LifePartnerProfileResponse;
import com.ve.community.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	CommunityBusinessService communityBusinessService;

	@Autowired
	LifePartnerProfileService lifePartnerProfileService;

	@Autowired
	AdvertisementService advertisementService;

	@Autowired
	CommunityJobService communityJobService;

	@Override
	public Admin createAdmin(AdminRequest adminRequest) {
		Admin admin = modelMapper.map(adminRequest, Admin.class);
		return adminRepository.save(admin);

	}

	@Override
	public Admin getById(Integer id) {
		return adminRepository.findById(id).orElseThrow(() -> new RuntimeException("admin not found for ID: " + id));

	}

	@Override
	public List<AdminResponse> getAllAdmin() {
		List<Admin> list_community = adminRepository.findAll();
		List<AdminResponse> list_adv = list_community.stream()

				.map(admin -> modelMapper.map(admin, AdminResponse.class)).collect(Collectors.toList());
		return list_adv;

	}

	@Override
	public ListOfActivateRequest getAllStatus() {

		List<CommunityBusinessResponse> communityBusinessResponse = communityBusinessService.getCommunity();
		List<LifePartnerProfileResponse> lifePartnerProfileResponse = lifePartnerProfileService.getAllProfiles();
		List<AdvertisementResponse> advertisementResponse = advertisementService.getAdvertisement();
		List<CommunityJobResponse> communityJobResponse = communityJobService.getJob();
		ListOfActivateRequest listOfAllStatus = new ListOfActivateRequest();
		listOfAllStatus.setAdvertisementResponse(advertisementResponse);
		listOfAllStatus.setCommunityBusinessResponse(communityBusinessResponse);
		listOfAllStatus.setCommunityJobResponse(communityJobResponse);
		listOfAllStatus.setLifePartnerProfileResponse(lifePartnerProfileResponse);
		return listOfAllStatus;
	}

	@Override
	public String saveAllStatus(ListOfActivateRequest listOfActivateRequest) {

		if (listOfActivateRequest.getCommunityBusinessResponse()!=null) {
		if (listOfActivateRequest.getCommunityBusinessResponse().size() > 0) {
			String msg = communityBusinessService.saveAll(listOfActivateRequest.getCommunityBusinessResponse());
		}
		}
		if (listOfActivateRequest.getCommunityJobResponse()!=null) {
		if (listOfActivateRequest.getCommunityJobResponse().size() > 0) {
			String msg1 = communityJobService.saveAll(listOfActivateRequest.getCommunityJobResponse());
		}
		}
		if (listOfActivateRequest.getLifePartnerProfileResponse()!=null) {
		if (listOfActivateRequest.getLifePartnerProfileResponse().size() > 0) {
			String msg2 = lifePartnerProfileService.saveAll(listOfActivateRequest.getLifePartnerProfileResponse());
		}
		}

		if (listOfActivateRequest.getAdvertisementResponse()!=null) {
			if (listOfActivateRequest.getAdvertisementResponse().size() > 0) {
				String msg2 = advertisementService.saveAll(listOfActivateRequest.getAdvertisementResponse());
			}
			}
		return "Saved";
	}

}
