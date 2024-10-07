package com.ve.community.payloads.response;

import lombok.Data;

@Data
public class CommunityBusinessResponse {
    private Integer id;
    private String communityIdNo;
    private String companyBusinessName;
    private String typeOfBusiness;
    private String houseNoNamePlotNo;
    private String streetColonyArea;
    private String  cityTownVillage;
    private String website;
    private String contactNo;
    private String mailId;
    private String locationLink;
    private String communityAdditionalBenefits;
    private String providerName;
    private String providerDesignation;
    private String descriptionAboutBusiness;
}