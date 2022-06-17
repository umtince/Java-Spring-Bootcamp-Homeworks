package com.mobileactionbootcamp.uincehw2.dst.dto;

import com.mobileactionbootcamp.uincehw2.cty.dto.CtyCitySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import lombok.Data;


@Data
public class DstDistrictSaveRequestDto {

    private String districtName;
    private CtyCitySaveRequestDto city;
}
