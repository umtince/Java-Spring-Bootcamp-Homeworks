package com.mobileactionbootcamp.uincehw2.nei.dto;

import com.mobileactionbootcamp.uincehw2.dst.dto.DstDistrictSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.dst.entity.DstDistrict;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class NeiNeighborhoodSaveRequestDto {
    private String neighborhoodName;
    private DstDistrictSaveRequestDto district;
}
