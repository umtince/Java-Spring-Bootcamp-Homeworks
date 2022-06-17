package com.mobileactionbootcamp.uincehw2.adr.dto;

import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import com.mobileactionbootcamp.uincehw2.dst.entity.DstDistrict;
import com.mobileactionbootcamp.uincehw2.nei.entity.NeiNeighborhood;
import com.mobileactionbootcamp.uincehw2.str.entity.StrStreet;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class AdrAddressDto {
    private Long id;
    private CntCountry country;
    private CtyCity city;
    private DstDistrict district;
    private NeiNeighborhood neighborhood;
    private StrStreet street;
    private Long apartmentNumber;
    private Long doorNumber;
}
