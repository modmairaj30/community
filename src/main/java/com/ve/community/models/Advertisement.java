package com.ve.community.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name="advertisement")
public class Advertisement {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 @NotBlank
	 @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Field must contain only letters and numbers")
	 @Column(name="advertisement_Name")
	 private String advertisementName;
	 @NotBlank
	 @Pattern(
			    regexp = "^(https?://)?([\\w\\d-]+\\.)+[\\w-]{2,}(\\:[0-9]{1,5})?(/[\\w\\d-./?%&=]*)?$",
			    message = "Invalid URL format."
			)
	 @Column(name="image_url")
	 private String imageUrl;
	 @NotBlank
	 @Pattern(
			    regexp = "^(https?://)?([\\w\\d-]+\\.)+[\\w-]{2,}(\\:[0-9]{1,5})?(/[\\w\\d-./?%&=]*)?$",
			    message = "Invalid URL format."
			)
	 @Column(name="link")
	 private String link;
	 //@NotBlank
	// @Pattern(
		//        regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", 
		//        message = "Invalid email address"
		 //   )
	// @Column(name="user_email")
	// private String userEmail;
	// @NotBlank  
	 @Column(name="user_id")
	 private String userId;
	// @Pattern(regexp = "^(approved|pending|rejected)$", message = "Profile status must be 'approved', 'pending', or 'rejected'")
	  @Column(name="advertisement_status")
	  private String advertisementStatus;
	// @NotBlank
	  //  @Pattern(
	  //      regexp = "^[0-9]{12}$", 
	  //  	    message = "Phone number must be exactly 12 digits."
	    //	)
	 @Column(name ="contact_no")
	    private String contactNo;
	 @Column(nullable = false)
	    private boolean deleted = false; // Default is false (not deleted).
	

}
