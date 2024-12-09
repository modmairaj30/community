package com.ve.community.payloads.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
public class AdvertisementRequest {
	 
	private Integer id;
	@NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Field must contain only letters and numbers")
	 private String advertisementName;
	@NotBlank
	 @Pattern(
			    regexp = "^(https?://)?([\\w\\d-]+\\.)+[\\w-]{2,}(\\:[0-9]{1,5})?(/[\\w\\d-./?%&=]*)?$",
			    message = "Invalid URL format."
			)
	 private String imageUrl;
	 @NotBlank
	 @Pattern(
			    regexp = "^(https?://)?([\\w\\d-]+\\.)+[\\w-]{2,}(\\:[0-9]{1,5})?(/[\\w\\d-./?%&=]*)?$",
			    message = "Invalid URL format."
			)
	 private String link;
	// private String userEmail;
	 @NotBlank  
	 private String userId;
	 @NotBlank
	    @Pattern(
	        regexp = "^[0-9]{12}$", 
	    	    message = "Phone number must be exactly 12 digits."
	    	)
	 private String contactNo;
	 @Pattern(regexp = "^(approved|pending|rejected)$", message = "advertisement status must be 'approved', 'pending', or 'rejected'")
	 private String advertisementStatus;
	 private boolean deleted = false; // Default is false (not deleted).
	 
}
