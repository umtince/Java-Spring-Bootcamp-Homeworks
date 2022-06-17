package com.mobileactionbootcamp.uincehw2.adr.converter;

import com.mobileactionbootcamp.uincehw2.adr.dto.AdrAddressDto;
import com.mobileactionbootcamp.uincehw2.adr.dto.AdrAddressSaveRequestByStreetDto;
import com.mobileactionbootcamp.uincehw2.adr.entity.AdrAddress;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdrAddressMapper {
    AdrAddressMapper INSTANCE = Mappers.getMapper(AdrAddressMapper.class);

    AdrAddress convertToAdrAddress(AdrAddressSaveRequestByStreetDto adrAddressSaveRequestByStreetDto);
    AdrAddressDto convertToAdrAddressDto(AdrAddress adrAddress);

}
