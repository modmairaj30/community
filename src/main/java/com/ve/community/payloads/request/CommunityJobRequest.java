package com.ve.community.payloads.request;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CommunityJobRequest {
    private Integer communityIdNo;

    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "CompanyJobName must not include numbers or special characters")
    private String companyJobName;

    @NotBlank(message = "Location area cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9\\s,.-]+$", message = "Location area can include letters, numbers, spaces, commas, periods, and hyphens only")
    private String locationArea;

    @NotBlank(message = "typeOfJob cannot be blank")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "typeOfJob must not include numbers or special characters")
    private String typeOfJob;

    @NotBlank(message = "position cannot be blank")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Position must not include numbers or special characters")
    private String position;

    @NotBlank(message = "qualification cannot be blank")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "qualification must not include numbers or special characters")
    private String qualification;

    @NotBlank(message = "specialSkills cannot be blank")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "specialSkills must not include numbers or special characters")
    private String specialSkills;

    @NotBlank(message = "Salary cannot be blank")
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "Salary can only include numbers and letters")
    private String salary;

    @NotBlank(message = "ContactNumber cannot be blank")
    @Pattern(regexp = "^[+]91[6-9][0-9]{9}$", message = "Please provide a valid Indian contact number with country code +91")
    private String contactNo;

    @NotBlank(message = "postBy cannot be blank")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "postBy must not include numbers or special characters")
    private String postBy;

    @NotBlank(message = "provider_designation cannot be blank")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "provider_designation must not include numbers or special characters")
    private String providerDesignation;

    private String jobStatus;

    @NotBlank(message = "Email cannot be blank")
    @Pattern(regexp = "^[\\w-\\.]+@[\\w-\\.]+\\.\\w{2,4}$", message = "Invalid email format")
    private String userEmail;

    @NotBlank(message = "userId cannot be blank")
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "userId can only include numbers and letters")
    private String userId;

    private boolean isDeleted =false;

}
