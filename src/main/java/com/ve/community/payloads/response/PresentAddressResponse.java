package com.ve.community.payloads.response;

import com.ve.community.models.Users;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;



@Data
public class PresentAddressResponse {
    private Integer Id;
    private String houseNoNamePlotNo;
    private String streetLandmark;
    private String village;
    private String mandalArea;
    private String district;
    private String state;
    private String phoneNo;
    private Integer baseId;
}