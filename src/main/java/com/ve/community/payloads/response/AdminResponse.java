package com.ve.community.payloads.response;

import lombok.Data;

@Data
public class AdminResponse {
	private Integer id;
	 private String email;
    private String mobileNo;
	 private String username;
	private boolean activate;
}
