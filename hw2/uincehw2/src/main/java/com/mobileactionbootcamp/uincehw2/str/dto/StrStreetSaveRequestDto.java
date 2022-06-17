package com.mobileactionbootcamp.uincehw2.str.dto;

import com.mobileactionbootcamp.uincehw2.nei.dto.NeiNeighborhoodSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.nei.entity.NeiNeighborhood;
import lombok.Data;

@Data
public class StrStreetSaveRequestDto {
    private String streetName;
    private NeiNeighborhoodSaveRequestDto neighborhood;
}
