package com.ve.community.payloads.response;


import lombok.Data;

@Data
public class UsersResponse {
    private Integer Id;
    private String name;
    private String  surname;
    private String sonOfOrDaughterOf;
    private String subcast;
    private String gotra;
    private String bloodGp;
    private String dateOfBirth;
    private String age;
    private String gender;
    private String email;
    private String newPassword;
    private String confirmNewPassword;
    private String assemblyConstituency;
    private String phoneNo1;
    private String phoneNo2;
    private String whatsappNo;
    private PermanentAddressResponse permanentAddressList;
    private PresentAddressResponse presentAddressList;
    private ProfessionalDetailsResponse professionalDetailsList;
    private String imageUrl;
}