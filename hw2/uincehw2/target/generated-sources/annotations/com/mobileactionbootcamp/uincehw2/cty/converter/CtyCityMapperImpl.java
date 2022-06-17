package com.mobileactionbootcamp.uincehw2.cty.converter;

import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountrySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import com.mobileactionbootcamp.uincehw2.cty.dto.CtyCityDto;
import com.mobileactionbootcamp.uincehw2.cty.dto.CtyCitySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-13T00:59:07+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class CtyCityMapperImpl implements CtyCityMapper {

    @Override
    public CtyCity convertToCtyCity(CtyCitySaveRequestDto ctyCitySaveRequestDto) {
        if ( ctyCitySaveRequestDto == null ) {
            return null;
        }

        CtyCity ctyCity = new CtyCity();

        ctyCity.setCityName( ctyCitySaveRequestDto.getCityName() );
        ctyCity.setPlateNumber( ctyCitySaveRequestDto.getPlateNumber() );
        ctyCity.setCountry( cntCountrySaveRequestDtoToCntCountry( ctyCitySaveRequestDto.getCountry() ) );

        return ctyCity;
    }

    @Override
    public CtyCityDto convertToCtyCityDto(CtyCity ctyCity) {
        if ( ctyCity == null ) {
            return null;
        }

        CtyCityDto ctyCityDto = new CtyCityDto();

        ctyCityDto.setId( ctyCity.getId() );
        ctyCityDto.setCityName( ctyCity.getCityName() );
        ctyCityDto.setPlateNumber( ctyCity.getPlateNumber() );
        ctyCityDto.setCountry( ctyCity.getCountry() );

        return ctyCityDto;
    }

    protected CntCountry cntCountrySaveRequestDtoToCntCountry(CntCountrySaveRequestDto cntCountrySaveRequestDto) {
        if ( cntCountrySaveRequestDto == null ) {
            return null;
        }

        CntCountry cntCountry = new CntCountry();

        cntCountry.setCountryName( cntCountrySaveRequestDto.getCountryName() );
        cntCountry.setCountryCode( cntCountrySaveRequestDto.getCountryCode() );

        return cntCountry;
    }
}
