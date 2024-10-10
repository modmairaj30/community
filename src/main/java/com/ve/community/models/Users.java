package com.ve.community.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

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
    
    @Column(name="image_url")
    private String imageUrl;
    
    @Column(name="ward_no")
    private String wardNO;
    
    @Column(name="activate")
    private Boolean activate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "base_id", referencedColumnName = "id")
    private List<PermanentAddress> permanentAddressList;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "base_id", referencedColumnName = "id")
    private List<PresentAddress> presentAddressListList;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "base_id", referencedColumnName = "id")
    private List<ProfessionalDetails> professionalDetailsListrDetailList;

}

