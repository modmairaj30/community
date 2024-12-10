package com.ve.community.payloads.request;


import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CommunityBusinessRequest {
    private Integer communityIdNo;
    
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Field must contain only letters and numbers")
    private String companyBusinessName;
   
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Field must contain only letters and numbers")
    private String typeOfBusiness;
   
    @NotBlank
    @Pattern(
    	    regexp = "^[a-zA-Z0-9\\-#/\\s]+$", 
    	    message = "House number, name, or plot number can contain only letters, numbers, spaces, and symbols like '-', '#', '/'."
    	)
    private String houseNoNamePlotNo;
   
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Field must contain only letters and numbers")
    private String streetColonyArea;
    
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Field must contain only letters and numbers")
    private String  cityTownVillage;
   
    @NotBlank
    @Pattern(
            regexp = "^(https?:\\/\\/)?([\\w.-]+)+(:\\d+)?(\\/.*)?$",
            message = "Invalid website URL"
        )
    private String website;
   
    @NotBlank
    @Pattern(
    	    regexp = "^[0-9]{12}$", 
    	    message = "Phone number must be exactly 12 digits."
    	)
    private String contactNo;
   
    @NotBlank
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", 
            message = "Invalid email address"
        )
    private String mailId;
  
    @Pattern(
		    regexp = "^(https?://)?([\\w\\d-]+\\.)+[\\w-]{2,}(\\:[0-9]{1,5})?(/[\\w\\d-./?%&=]*)?$",
		    message = "Invalid URL format."
		)
    private String locationLink;
   
    @Pattern(
    	    regexp = "^[a-zA-Z0-9\\s]+$",
    	    message = "Field must contain only letters, numbers, and spaces"
    	)
    private String communityAdditionalBenefits;
   
    @Pattern(
    	    regexp = "^[a-zA-Z0-9\\s]+$",
    	    message = "Field must contain only letters, numbers, and spaces"
    	)
    private String providerName;
  
    @Pattern(
    	    regexp = "^[a-zA-Z0-9\\s]+$",
    	    message = "Field must contain only letters, numbers, and spaces"
    	)
    private String providerDesignation;
  
    @Pattern(
    	    regexp = "^[a-zA-Z0-9\\s]+$",
    	    message = "Field must contain only letters, numbers, and spaces"
    	)
    private String descriptionAboutBusiness;
   // private Boolean activate;
   
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", 
            message = "Invalid email address"
        )
    private String userEmail;
    private String userId;

  @Pattern(regexp = "^(approved|pending|rejected)$", message = "Profile status must be 'approved', 'pending', or 'rejected'")
    private String businessStatus;
   
  private boolean deleted = false; // Default is false (not deleted).
}
