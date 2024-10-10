package com.ve.community.payloads.response;

import lombok.Data;

@Data
public class RefferAndEarnResponse {

	private Integer id;
	private String referralName;
	private String userEmail;
	private String userId;
}
