package com.ve.community.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="professionalDetails")
public class ProfessionalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="job_business")
    private String jobBusiness;
    @Column(name="designation")
    private String designation;
    @Column(name="company_name")
    private String  companyName;
    @Column(name = "house_no_name_plot_no")
    private String houseNoNamePlotNo;
    @Column(name="street_landmark")
    private String streetLandmark;
    @Column(name="village")
    private String village;
    @Column(name="mandal_area")
    private String mandalArea;
    @Column(name="district")
    private String district;
    @Column(name="state")
    private String state;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "base_id", nullable = false)
    private Users user;
}