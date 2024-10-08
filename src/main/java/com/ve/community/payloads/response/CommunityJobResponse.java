package com.ve.community.payloads.response;


import lombok.Data;

@Data
public class CommunityJobResponse {
    private Integer communityIdNo;
    private String  companyJobName;
    private String locationArea;
    private String typeOfJob;
    private String position;
    private String qualification;
    private String specialSkills;
    private String salary;
    private String contactNo;
    private String postBy;
    private String providerDesignation;
}
