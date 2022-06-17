package com.mobileactionbootcamp.uincehw2.str.dto;

import com.mobileactionbootcamp.uincehw2.nei.entity.NeiNeighborhood;
import lombok.Data;

@Data
public class StrStreetDto {
    private Long id;
    private String streetName;
    private NeiNeighborhood neighborhood;
}
