package com.mobileactionbootcamp.uincehw2.cty.dto;

import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountrySaveRequestDto;
import lombok.Data;

@Data
public class CtyCitySaveRequestDto {
    private String cityName;
    private Long plateNumber;
    private CntCountrySaveRequestDto country;
}
