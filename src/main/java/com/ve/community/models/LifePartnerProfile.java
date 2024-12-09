
package com.ve.community.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name="life_partner_profile")
@Data
public class LifePartnerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer communityIdNo;
   
   // @NotBlank
   // @Pattern(regexp = "^(?=.*[A-Z])[a-zA-Z]+$",message = "Applicant name must contain only letters and at least one uppercase letter")
    @Column(name = "applicant_name")
    private String applicantName;
    
    //@NotBlank
    //@Pattern(regexp = "^[a-zA-Z]+$", message = "Relation must contain only letters")
    @Column(name="myself_my_son_my_daughter_my_sister_my_brother")
    private String  myselfMySonMyDaughterMySisterMyBrother;
    
    //@NotBlank
    //@Pattern(regexp = "^(?=.*[A-Z])[a-zA-Z]+$",message = "Applicant name must contain only letters and at least one uppercase letter")
    @Column(name="name_of_the_person")
    private String nameOfThePerson;
   // @NotBlank
    //@Pattern(regexp = "^[a-zA-Z]+$", message = "field  must contain only letters")
    @Column(name="son_of_daughter_of")
    private String sonOfDaughterOf;
  //  @Pattern(regexp = "^[a-zA-Z]+$", message = "subcast name must contain only letters")
   // @NotBlank
    @Column(name="subcast")
    private String subcast;
   // @NotBlank
   // @Pattern(regexp = "^[a-zA-Z]+$", message = "gotra  must contain only letters")
    @Column(name="gotra(m)")
    private String gotra;
   // @NotBlank
   // @Pattern(regexp = "^[a-zA-Z]+$", message = "mother tongue must contain only letters")
    @Column(name = "mother_tongue")
    private String motherTongue;
    
   // @NotBlank
    @Column(name = "present_address")
    private String presentAddress;
    //@NotBlank
    @Column(name="education")
    private String education;
    
    //@NotBlank
    @Column(name="professional_job_status")
    private String  professionalJobStatus;
    
    //@NotBlank
    @Column(name="company_business_name")
    private String companyBusinessName;
    //@NotBlank
    @Column(name="office_address")
    private String officeAddress;
    //@NotBlank
    @Column(name="designation")
    private String designation;
    //@NotBlank
   // @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Field must contain only letters and numbers")
    @Column(name="salary_income")
    private String salaryIncome;
    //@NotBlank
    @Column(name="willing_to_same_subcast_other_subcast")
    private String willingToSameSubcastOtherSubcast;
   // @NotBlank
    @Column(name = "star")
    private String star;
    //@NotBlank
    @Column(name = "rasi")
    private String rasi;
    //@NotBlank
    @Column(name = "birth_country")
    private String birthCountry;
  //  @NotBlank
    @Column(name = "birth_state")
    private String birthState;
    //@NotBlank
    @Column(name = "birth_city_town")
    private String birthCityTown;
    //@NotBlank
    @Column(name = "birth_village_area")
    private String birthVillageArea;
  //  @NotBlank
    @Column(name = "birth_time")
    private String birthTime;
  //  @NotBlank
    @Column(name = "marital_status")
    private String maritalStatus;
   // @NotBlank
    @Column(name="height_weight")
    private String heightWeight;
  //  @NotBlank
    @Column(name="family_status_middle_upper_middle_rich_poor")
    private String  familyStatusMiddleUpperMiddleRichPoor;
    //@NotBlank
    @Column(name="family_type_joint_small_family_single")
    private String familyTypeJointSmallFamilySingle;
    
  //  @NotBlank
    @Column(name="family_members_mother")
    private String familyMemberMother;
   
    //@NotBlank
    @Column(name="family_members_father")
    private String familyMemberFather;
   
    @Column(name="family_members_brothers")
    private String familyMemberBrothers;
    @Column(name="family_members_sisters")
    private String familyMembersSisters;
   // @NotBlank
    @Column(name="physical_status")
    private String physicalStatus;
    //@NotBlank
    @Column(name="citizenship")
    private String citizenship;
   // @NotBlank
  //  @Pattern(
  //  		regexp = "^[+]91[6-9][0-9]{9}$", 
  //  	    message = "Field must follow indian pattern."
   // 	)
    @Column(name="mobile_no")
    private String mobileNo;
   // @NotBlank
   // @Pattern(
    //		regexp = "^[+]91[6-9][0-9]{9}$",
    //	    message = "Field must follow indian pattern"
    //	)
    @Column(name="w_a_no")
    private String whatsAppNo;
   // @NotBlank
   // @Pattern(
   //         regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", 
     //       message = "Invalid email address"
   //     )
    @Column(name = "email_id")
    private String emailId;
   // @NotBlank
    @Column(name="write_your_requirements")
    private String writeYourRequirements;
   // @Pattern(regexp = "^(approved|pending|rejected)$", message = "Profile status must be 'approved', 'pending', or 'rejected'")
    @Column(name="profile_status")
    private String profileStatus;
    //@NotBlank
   // @Pattern(
     //       regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", 
         //   message = "Invalid email address"
      //  )
    @Column(name="user_email")
    private String userEmail;
   // @NotBlank
    @Column(name="user_id")
    private String userId;
    @Column(nullable = false)
    private boolean deleted = false; // Default is false (not deleted).

}
