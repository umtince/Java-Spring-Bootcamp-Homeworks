package com.mobileactionbootcamp.uincehw2.str.converter;

import com.mobileactionbootcamp.uincehw2.str.dto.StrStreetDto;
import com.mobileactionbootcamp.uincehw2.str.dto.StrStreetSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.str.entity.StrStreet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StrStreetMapper {
    StrStreetMapper INSTANCE = Mappers.getMapper(StrStreetMapper.class);

    StrStreetDto convertToStrStreetDto(StrStreet strStreet);
    StrStreet convertToStrStreet(StrStreetSaveRequestDto strStreetSaveRequestDto);
    StrStreet convertToStrStreet(StrStreetDto strStreetDto);
}
