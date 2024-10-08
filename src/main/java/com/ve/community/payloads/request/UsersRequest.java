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
    private PermanentAddressRequest permanentAddressList;
    private PresentAddressRequest presentAddressList;
    private ProfessionalDetailsRequest professionalDetailsList;
    private String imageUrl;

    @Override
    public String toString() {
        return "UsersRequest{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sonOfOrDaughterOf='" + sonOfOrDaughterOf + '\'' +
                ", subcast='" + subcast + '\'' +
                ", gotra='" + gotra + '\'' +
                ", bloodGp='" + bloodGp + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", assemblyConstituency='" + assemblyConstituency + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", whatsappNo='" + whatsappNo + '\'' +
                ", email='" + email + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", confirmNewPassword='" + confirmNewPassword + '\'' +
                ", permanentAddressList=" + permanentAddressList +
                ", presentAddressList=" + presentAddressList +
                ", professionalDetailsList=" + professionalDetailsList +
                '}';
    }
}
