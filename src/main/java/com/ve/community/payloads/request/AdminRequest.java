package com.ve.community.payloads.request;

import jakarta.persistence.Column;
import lombok.Data;
@Data
public class AdminRequest {
	 private Integer id;
	 private String email;
     private String mobileNo;
	 private String username;
	private boolean activate;
	
}
