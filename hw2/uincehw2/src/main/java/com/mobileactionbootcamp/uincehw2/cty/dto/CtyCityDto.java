package com.mobileactionbootcamp.uincehw2.cty.dto;

import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import lombok.Data;

@Data
public class CtyCityDto {
    private Long id;
    private String cityName;
    private Long plateNumber;
    private CntCountry country;
}
