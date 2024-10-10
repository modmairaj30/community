package com.ve.community.payloads.response;

import lombok.Data;

@Data
public class AdvertisementResponse {
	private Integer id;

private String advertisementName;

private String imageUrl;

private String link;

private String userEmail;
private String userId;

}
