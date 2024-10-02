package com.ve.community.payloads.response;

import lombok.Data;

@Data
public class PermanentAddressResponse {
    private Integer Id;
    private String houseNoNamePlotNo;
    private String streetLandmark;
    private String  village;
    private String mandalArea;
    private String district;
    private String state;
    private String phoneNo;
    private Integer baseId;

    @Override
    public String toString() {
        return "PermanentAddressResponse{" +
                "Id=" + Id +
                ", houseNoNamePlotNo='" + houseNoNamePlotNo + '\'' +
                ", streetLandmark='" + streetLandmark + '\'' +
                ", village='" + village + '\'' +
                ", mandalArea='" + mandalArea + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", baseId=" + baseId +
                '}';
    }
}
