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
    private String phoneNo;
    private Integer baseId;

    @Override
    public String toString() {
        return "PermanentAddressRequest{" +
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

