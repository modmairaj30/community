package com.ve.community.payloads.request;



import lombok.Data;

@Data
public class CommunityJobRequest {
    private Integer id;
    private String companyJobName;
    private String locationArea;
    private String typeOfJob;
    private String position;
    private String qualification;
    private String specialSkills;
    private String salary;
    private String contactNo;
    private String postBy;
    private String providerDesignation;
    private String communityIdNo;
}
