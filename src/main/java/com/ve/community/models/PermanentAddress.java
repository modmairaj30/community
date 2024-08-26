package com.ve.community.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="permanent_address")
public class PermanentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "house_no_name_plot_no")
    private String houseNoNamePlotNo;
    @Column(name="street_landmark")
    private String streetLandmark;
    @Column(name="village")
    private String  village;
    @Column(name="mandal_area")
    private String mandalArea;
    @Column(name="district")
    private String district;
    @Column(name="state")
    private String state;
    @Column(name="phone no")
    private String phoneNo;
    @JoinColumn(name = "base_id", referencedColumnName = "id")
    @ManyToOne
    private Users baseId;
}
