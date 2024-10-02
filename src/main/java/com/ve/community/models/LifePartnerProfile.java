package com.ve.community.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="bio_data")
@Data
public class LifePartnerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "applicant_name")
    private String applicantName;
    @Column(name="community_id_no")
    private String communityIdNo;
    @Column(name="myself_my_son_my_daughter_my_sister_my_brother")
    private String  myselfMySonMyDaughterMySisterMyBrother;
    @Column(name="name_of_the_person")
    private String nameOfThePerson;
    @Column(name="son_of_daughter_of")
    private String sonOfDaughterOf;
    @Column(name="subcast")
    private String subcast;
    @Column(name="gotra(m)")
    private String gotra;
    @Column(name = "mother_tongue")
    private String motherTongue;
    @Column(name = "present_address")
    private String presentAddress;
    @Column(name="education")
    private String education;
    @Column(name="professional_job_status")
    private String  professionalJobStatus;
    @Column(name="company_business_name")
    private String companyBusinessName;
    @Column(name="office_address")
    private String officeAddress;
    @Column(name="designation")
    private String designation;
    @Column(name="salary_income")
    private String salaryIncome;
    @Column(name="willing_to_same_subcast_other_subcast")
    private String willingToSameSubcastOtherSubcast;
    @Column(name = "star")
    private String star;
    @Column(name = "rasi")
    private String rasi;
    @Column(name = "birth_country")
    private String birthCountry;
    @Column(name = "birth_state")
    private String birthState;
    @Column(name = "birth_city_town")
    private String birthCityTown;
    @Column(name = "birth_village_area")
    private String birthVillageArea;
    @Column(name = "birth_time")
    private String birthTime;
    @Column(name = "marital_status")
    private String maritalStatus;
    @Column(name="height_weight")
    private String heightWeight;
    @Column(name="family_status_middle_upper_middle_rich_poor")
    private String  familyStatusMiddleUpperMiddleRichPoor;
    @Column(name="family_type_joint_small_family_single")
    private String familyTypeJointSmallFamilySingle;
    @Column(name="family_members_mother")
    private String familyMemberMother;
    @Column(name="family_members_father")
    private String familyMemberFather;
    @Column(name="family_members_brothers")
    private String familyMemberBrothers;
    @Column(name="family_members_sisters")
    private String familyMembersSisters;
    @Column(name="physical_status")
    private String physicalStatus;
    @Column(name="citizenship")
    private String citizenship;
    @Column(name="mobile_no")
    private String mobileNo;
    @Column(name="w_a_no")
    private String whatsAppNo;
    @Column(name = "email_id")
    private String emailId;
    @Column(name="write_your_requirements")
    private String writeYourRequirements;


}
