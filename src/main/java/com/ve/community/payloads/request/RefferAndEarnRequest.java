package com.ve.community.payloads.request;

import lombok.Data;

@Data
public class RefferAndEarnRequest {

	private Integer id;
	private String referralName;
	private String userEmail;
	private String userId;
}
