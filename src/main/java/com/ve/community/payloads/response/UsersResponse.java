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
    private PermanentAddressResponse permanentAddressList;
    private PresentAddressResponse presentAddressList;
    private ProfessionalDetailsResponse professionalDetailsList;

    @Override
    public String toString() {
        return "UsersResponse{" +
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
                ", phoneNo1='" + phoneNo1 + '\'' +
                ", phoneNo2='" + phoneNo2 + '\'' +
                ", whatsappNo='" + whatsappNo + '\'' +
                ", permanentAddressList=" + permanentAddressList +
                ", presentAddressList=" + presentAddressList +
                ", professionalDetailsList=" + professionalDetailsList +
                '}';
    }
}