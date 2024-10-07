package com.ve.community.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "job")
public class CommunityJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="community_id_no")
    private String communityIdNo;
    @Column(name = "company_job_name")
    private String companyJobName;

    @Column(name = "location_area")
    private String locationArea;

    @Column(name ="type_of_job")
    private String typeOfJob;

    @Column(name ="position")
    private String position;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "special_skills")
    private String specialSkills;

    @Column(name ="salary")
    private String salary;

    @Column(name ="contact_no")
    private String contactNo;

    @Column(name = "post_by")
    private String postBy;

    @Column(name ="provider_designation")
    private String providerDesignation;

}