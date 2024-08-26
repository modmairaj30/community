package com.ve.community.payloads.request;

import com.ve.community.models.Users;
import lombok.Data;
@Data
public class PresentAddressRequest {

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