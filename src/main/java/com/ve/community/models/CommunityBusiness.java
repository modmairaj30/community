package com.ve.community.models;


import jakarta.persistence.*;
        import lombok.Data;

@Data
@Entity
@Table(name = "business")
public class CommunityBusiness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="community_id_no")
    private String communityIdNo;
    @Column(name = "company_business_name")
    private String companyBusinessName;

    @Column(name="type_of_business")
    private String typeOfBusiness;

    @Column(name = "house_no_name_plot_no")
    private String houseNoNamePlotNo;

    @Column(name="street_colony_area")
    private String streetColonyArea;

    @Column(name="city_town_village")
    private String  cityTownVillage;

    @Column(name ="website")
    private String website;

    @Column(name ="contact_no")
    private String contactNo;

    @Column(name ="mail_id")
    private String mailId;

    @Column(name ="location_link")
    private String locationLink;

    @Column(name ="community_additional_benefits")
    private String communityAdditionalBenefits;

    @Column(name ="provider_name")
    private String providerName;

    @Column(name ="provider_designation")
    private String providerDesignation;

   /* @Column(name = "community_id_no")
    private String communityIdNo;*/

    @Column(name = "description_about_business")
    private String descriptionAboutBusiness;
}
