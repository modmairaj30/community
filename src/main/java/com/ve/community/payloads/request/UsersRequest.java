package com.ve.community.payloads.request;

import java.util.List;

import lombok.Data;
@Data
    public class UsersRequest {
    private Integer Id;
    private String name;
    private  String  surname;
    private String sonOfOrDaughterOf;
    private String subcast;
    private String gotra;
    private String bloodGp;
    private String dateOfBirth;
    private String age;
    private String gender;
    private String assemblyConstituency;
    private String mobileNo;
    private String whatsappNo;
    private String wardNo;
    private String email;
    private String newPassword;
    private String confirmNewPassword;
    private List<PermanentAddressRequest> permanentAddressList;
    private List<PresentAddressRequest> presentAddressListList;
    private List<ProfessionalDetailsRequest> professionalDetailsListrDetailList;
    private String imageUrl;
    private String userStatus;
    
    private boolean deleted = false; // Default is false (not deleted).


}
