package com.ve.community.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "business")
public class CommunityBusiness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer communityIdNo;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Field must contain only letters and numbers")
    @Column(name = "company_business_name")
    private String companyBusinessName;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Field must contain only letters and numbers")
    @Column(name="type_of_business")
    private String typeOfBusiness;
    @NotBlank
    @Pattern(
    	    regexp = "^[a-zA-Z0-9\\-#/\\s]+$", 
    	    message = "House number, name, or plot number can contain only letters, numbers, spaces, and symbols like '-', '#', '/'."
    	)
    @Column(name = "house_no_name_plot_no")
    private String houseNoNamePlotNo;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Field must contain only letters and numbers")
    @Column(name="street_colony_area")
    private String streetColonyArea;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Field must contain only letters and numbers")
    @Column(name="city_town_village")
    private String  cityTownVillage;
    @NotBlank
    @Pattern(
            regexp = "^(https?:\\/\\/)?([\\w.-]+)+(:\\d+)?(\\/.*)?$",
            message = "Invalid website URL"
        )
    @Column(name ="website")
    private String website;
    @NotBlank
    @Pattern(
    	    regexp = "^[0-9]{13}$", 
    	    message = "Phone number must be exactly 13 digits."
    	)
    @Column(name ="contact_no")
    private String contactNo;
    @NotBlank
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", 
            message = "Invalid email address"
        )
    @Column(name ="mail_id")
    private String mailId;
    @Pattern(
		    regexp = "^(https?://)?([\\w\\d-]+\\.)+[\\w-]{2,}(\\:[0-9]{1,5})?(/[\\w\\d-./?%&=]*)?$",
		    message = "Invalid URL format."
		)
    @Column(name ="location_link")
    private String locationLink;
    @Pattern(
    	    regexp = "^[a-zA-Z0-9\\s]+$",
    	    message = "Field must contain only letters, numbers, and spaces"
    	)
    @Column(name ="community_additional_benefits")
    private String communityAdditionalBenefits;
    @Pattern(
    	    regexp = "^[a-zA-Z0-9\\s]+$",
    	    message = "Field must contain only letters, numbers, and spaces"
    	)
    @Column(name ="provider_name")
    private String providerName;
    @Pattern(
    	    regexp = "^[a-zA-Z0-9\\s]+$",
    	    message = "Field must contain only letters, numbers, and spaces"
    	)
    @Column(name ="provider_designation")
    private String providerDesignation;
    @Pattern(
    	    regexp = "^[a-zA-Z0-9\\s]+$",
    	    message = "Field must contain only letters, numbers, and spaces"
    	)
    @Column(name = "description_about_business")
    private String descriptionAboutBusiness;
    @Pattern(regexp = "^(approved|pending|rejected)$", message = "Profile status must be 'approved', 'pending', or 'rejected'")
    @Column(name="business_status")
    private String businessStatus;
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", 
            message = "Invalid email address"
        )
    @Column(name="user_email")
    private String userEmail;
    
    @Column(name="user_id")
    private String userId;
 
    @Column(nullable = false)
    private boolean deleted = false; // Default is false (not deleted).

}
