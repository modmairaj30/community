package com.ve.community.payloads.request;

import com.ve.community.models.Users;
import lombok.Data;
@Data
public class ProfessionalDetailsRequest {
    private Integer Id;
    private String jobBusiness;
    private String designation;
    private String  companyName;
    private String houseNoNamePlotNo;
    private String streetLandmark;
    private String village;
    private String mandalArea;
    private String district;
    private String state;
    private Integer baseId;
}