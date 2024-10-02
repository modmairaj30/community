package com.ve.community.payloads.request;

import com.ve.community.models.PermanentAddress;
import com.ve.community.models.PresentAddress;
import com.ve.community.models.ProfessionalDetails;
import jakarta.persistence.Column;
import lombok.Data;
import java.util.List;
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
    private String email;
    private String newPassword;
    private String confirmNewPassword;
    private List<PermanentAddressRequest> permanentAddressList;
    private List<PresentAddressRequest> presentAddressList;
    private List<ProfessionalDetailsRequest> professionalDetailsList;
}
