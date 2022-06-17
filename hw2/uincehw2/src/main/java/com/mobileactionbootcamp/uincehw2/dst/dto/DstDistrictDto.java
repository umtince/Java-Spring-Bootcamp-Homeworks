package com.mobileactionbootcamp.uincehw2.dst.dto;

import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import lombok.Data;

@Data
public class DstDistrictDto {
    private Long id;
    private String districtName;
    private CtyCity city;
}
