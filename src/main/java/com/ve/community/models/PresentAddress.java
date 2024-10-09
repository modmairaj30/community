package com.ve.community.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="present_address")
public class PresentAddress {
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
    @Column(name="phone_no")
    private String phoneNo;
    @Column(name="pin")
    private String pin;
    @JoinColumn(name = "base_id", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER)
    private Users user;

    @Override
    public String toString() {
        return "PresentAddress{" +
                "Id=" + Id +
                ", houseNoNamePlotNo='" + houseNoNamePlotNo + '\'' +
                ", streetLandmark='" + streetLandmark + '\'' +
                ", village='" + village + '\'' +
                ", mandalArea='" + mandalArea + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", user=" + user +
                '}';
    }
}