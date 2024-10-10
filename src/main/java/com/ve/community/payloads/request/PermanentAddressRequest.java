package com.ve.community.payloads.request;
import lombok.Data;
@Data
    public class PermanentAddressRequest {
    private Integer Id;
    private String houseNoNamePlotNo;
    private String streetLandmark;
    private String village;
    private String mandalArea;
    private String district;
    private String state;
    private String pin;
    private Integer baseId;

}


