package com.ve.community.payloads.response;

import com.ve.community.models.PermanentAddress;
import com.ve.community.models.PresentAddress;
import com.ve.community.models.ProfessionalDetails;
import lombok.Data;
import java.util.List;
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
    private String assemblyConstituency;
    private String phoneNo1;
    private String phoneNo2;
    private String whatsappNo;
    private List<PermanentAddressResponse> permanentAddressList;
    private List<PresentAddressResponse> presentAddressListList;
    private List<ProfessionalDetailsResponse> professionalDetailsListrDetailList;


}