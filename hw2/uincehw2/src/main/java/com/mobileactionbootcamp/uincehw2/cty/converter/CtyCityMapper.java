package com.mobileactionbootcamp.uincehw2.cty.converter;

import com.mobileactionbootcamp.uincehw2.cty.dto.CtyCityDto;
import com.mobileactionbootcamp.uincehw2.cty.dto.CtyCitySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CtyCityMapper {
    CtyCityMapper INSTANCE = Mappers.getMapper(CtyCityMapper.class);

    CtyCity convertToCtyCity(CtyCitySaveRequestDto ctyCitySaveRequestDto);
    CtyCityDto convertToCtyCityDto(CtyCity ctyCity);
}
