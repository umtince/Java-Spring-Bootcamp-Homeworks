package com.mobileactionbootcamp.uincehw2.dst.converter;

import com.mobileactionbootcamp.uincehw2.dst.dto.DstDistrictDto;
import com.mobileactionbootcamp.uincehw2.dst.dto.DstDistrictSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.dst.entity.DstDistrict;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DstDistrictMapper {
    DstDistrictMapper INSTANCE = Mappers.getMapper(DstDistrictMapper.class);

    DstDistrictDto convertToDstDistrictDto(DstDistrict dstDistrict);
    DstDistrict convertToDstDistrict(DstDistrictSaveRequestDto dstDistrictSaveRequestDto);
}
