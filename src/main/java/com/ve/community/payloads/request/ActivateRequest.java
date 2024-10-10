package com.ve.community.payloads.request;

import lombok.Data;

@Data
public class ActivateRequest {
	private Integer id;
	private boolean activate;

}
