package com.ve.community.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name="name")
    private String name;
    @Column(name="surname")
    private  String  surname;
    @Column(name = "son_of_or_daughter_of")
    private String sonOfOrDaughterOf;
    @Column(name="subcast")
    private String subcast;
    @Column(name="gotra(m)")
    private String gotra;
    @Column(name="blood_gp")
    private String bloodGp;
    @Column(name="date_of_birth")
    private String dateOfBirth;
    @Column(name="age")
    private String age;
    @Column(name="gender")
    private String gender;
    @Column(name="assembly_constituency(vote)")
    private String assemblyConstituency;
    @Column(name="ph_no1")
    private String phoneNo1;
    @Column(name="ph_no2")
    private String phoneNo2;
    @Column(name="w_p_no")
    private String whatsappNo;
    
    @Column(name="email")
    private String email;
    @Column(name="new_password")
    private String newPassword;
    @Column(name="confrim_new_password")
    private String confirmNewPassword;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private PermanentAddress permanentAddressList;


    @OneToOne(fetch = FetchType.EAGER,mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private PresentAddress presentAddressList;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private ProfessionalDetails professionalDetailsList;


    @Override
    public String toString() {
        return "Users{" +
                "id=" + Id +
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
                ", presentAddressListList=" + presentAddressList +
                ", professionalDetailsListrDetailList=" + professionalDetailsList +
                '}';
    }
}

