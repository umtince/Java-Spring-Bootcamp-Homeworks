package com.mobileactionbootcamp.uincehw2.cnt.converter;

import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountryDto;
import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountrySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-13T00:59:07+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class CntCountryMapperImpl implements CntCountryMapper {

    @Override
    public CntCountry convertToCntCountry(CntCountrySaveRequestDto cntCountrySaveRequestDto) {
        if ( cntCountrySaveRequestDto == null ) {
            return null;
        }

        CntCountry cntCountry = new CntCountry();

        cntCountry.setCountryName( cntCountrySaveRequestDto.getCountryName() );
        cntCountry.setCountryCode( cntCountrySaveRequestDto.getCountryCode() );

        return cntCountry;
    }

    @Override
    public CntCountryDto convertToCntCountryDto(CntCountry cntCountry) {
        if ( cntCountry == null ) {
            return null;
        }

        CntCountryDto cntCountryDto = new CntCountryDto();

        cntCountryDto.setId( cntCountry.getId() );
        cntCountryDto.setCountryName( cntCountry.getCountryName() );
        cntCountryDto.setCountryCode( cntCountry.getCountryCode() );

        return cntCountryDto;
    }
}
