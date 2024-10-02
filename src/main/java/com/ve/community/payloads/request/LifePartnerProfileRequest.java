package com.ve.community.payloads.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LifePartnerProfileRequest {
    private Integer id;
    private String applicantName;
    private String communityIdNo;
    private String  myselfMySonMyDaughterMySisterMyBrother;
    private String nameOfThePerson;
    private String sonOfDaughterOf;
    private String subcast;
    private String gotra;
    private String motherTongue;
    private String presentAddress;
    private String education;
    private String  professionalJobStatus;
    private String companyBusinessName;
    private String officeAddress;
    private String designation;
    private String salaryIncome;
    private String willingToSameSubcastOtherSubcast;
    private String star;
    private String rasi;
    private String birthCountry;
    private String birthState;
    private String birthCityTown;
    private String birthVillageArea;
    private String birthTime;
    private String maritalStatus;
    private String heightWeight;
    private String  familyStatusMiddleUpperMiddleRichPoor;
    private String familyTypeJointSmallFamilySingle;
    private String physicalStatus;
    private String citizenship;
    private String mobileNo;
    private String whatsAppNo;
    private String emailId;
    private String writeYourRequirements;

}
