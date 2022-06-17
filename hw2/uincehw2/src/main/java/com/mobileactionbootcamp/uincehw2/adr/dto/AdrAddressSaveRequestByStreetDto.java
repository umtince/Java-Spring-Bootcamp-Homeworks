package com.mobileactionbootcamp.uincehw2.adr.dto;

import com.mobileactionbootcamp.uincehw2.str.dto.StrStreetSaveRequestDto;
import lombok.Data;

@Data
public class AdrAddressSaveRequestByStreetDto {
    private Long apartmentNumber;
    private Long doorNumber;
    private StrStreetSaveRequestDto street;
    //takes only the street dto because other entities are chained within street dto
}
