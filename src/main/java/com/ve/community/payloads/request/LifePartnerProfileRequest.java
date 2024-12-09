package com.ve.community.payloads.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LifePartnerProfileRequest {
    private Integer communityIdNo;
    @Pattern(regexp = "^(?=.*[A-Z])[a-zA-Z]+$",message = "Applicant name must contain only letters and at least one uppercase letter")
    private String applicantName;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Relation must contain only letters")
    private String  myselfMySonMyDaughterMySisterMyBrother;
    @Pattern(regexp = "^(?=.*[A-Z])[a-zA-Z]+$",message = " name must contain only letters and at least one uppercase letter")
    private String nameOfThePerson;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "field  must contain only letters")
    private String sonOfDaughterOf;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "subcast name must contain only letters")
    private String subcast;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "gotra  must contain only letters")
    private String gotra;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "mother tongue must contain only letters")
    private String motherTongue;
    @NotBlank
    private String presentAddress;
    @NotBlank
    private String education;
    @NotBlank
    private String  professionalJobStatus;
    @NotBlank
    private String companyBusinessName;
    @NotBlank
    private String officeAddress;
    @NotBlank
    private String designation;
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Field must contain only letters and numbers")
    private String salaryIncome;
    @NotBlank
    private String willingToSameSubcastOtherSubcast;
    @NotBlank
    private String star;
    @NotBlank
    private String rasi;
    @NotBlank
    private String birthCountry;
    @NotBlank
    private String birthState;
    @NotBlank
    private String birthCityTown;
    @NotBlank
    private String birthVillageArea;
    @NotBlank
    private String birthTime;
    @NotBlank
    private String maritalStatus;
    @NotBlank
    private String heightWeight;
    @NotBlank
    private String  familyStatusMiddleUpperMiddleRichPoor;
    @NotBlank
    private String familyTypeJointSmallFamilySingle;
    @NotBlank
    private String physicalStatus;
    @NotBlank
    private String citizenship;
    @NotBlank
    @Pattern(
    		regexp = "^[+]91[6-9][0-9]{9}$", 
    	    message = "Field must follow indian pattern."
    	)
    private String mobileNo;
    @NotBlank
    @Pattern(
    		regexp = "^[+]91[6-9][0-9]{9}$", 
    	    message = "Field must follow indian pattern."
    	)
    private String whatsAppNo;
    @NotBlank
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", 
            message = "Invalid email address"
        )
    private String emailId;
    @NotBlank
    private String writeYourRequirements;
    @NotBlank
     private String familyMemberMother;
    @NotBlank
    private String familyMemberFather;
    @NotBlank
    private String familyMemberBrothers;
    @NotBlank
    private String familyMembersSisters;
    @NotBlank
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", 
            message = "Invalid email address"
        )
    private String userEmail;
    @NotBlank
    private String userId;
    @Pattern(regexp = "^(approved|pending|rejected)$", message = "Profile status must be 'approved', 'pending', or 'rejected'")
    private String profileStatus;
    private boolean deleted = false; // Default is false (not deleted).

}
