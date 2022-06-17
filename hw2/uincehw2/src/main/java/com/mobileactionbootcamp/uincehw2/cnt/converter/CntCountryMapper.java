package com.mobileactionbootcamp.uincehw2.cnt.converter;

import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountryDto;
import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountrySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CntCountryMapper {
    CntCountryMapper INSTANCE = Mappers.getMapper(CntCountryMapper.class);

    CntCountry convertToCntCountry(CntCountrySaveRequestDto cntCountrySaveRequestDto);
    CntCountryDto convertToCntCountryDto(CntCountry cntCountry);
}
