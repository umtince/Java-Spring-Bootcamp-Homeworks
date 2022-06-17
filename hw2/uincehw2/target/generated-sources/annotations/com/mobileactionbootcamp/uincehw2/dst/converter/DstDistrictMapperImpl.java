package com.mobileactionbootcamp.uincehw2.dst.converter;

import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountrySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import com.mobileactionbootcamp.uincehw2.cty.dto.CtyCitySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import com.mobileactionbootcamp.uincehw2.dst.dto.DstDistrictDto;
import com.mobileactionbootcamp.uincehw2.dst.dto.DstDistrictSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.dst.entity.DstDistrict;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-13T00:59:07+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class DstDistrictMapperImpl implements DstDistrictMapper {

    @Override
    public DstDistrictDto convertToDstDistrictDto(DstDistrict dstDistrict) {
        if ( dstDistrict == null ) {
            return null;
        }

        DstDistrictDto dstDistrictDto = new DstDistrictDto();

        dstDistrictDto.setId( dstDistrict.getId() );
        dstDistrictDto.setDistrictName( dstDistrict.getDistrictName() );
        dstDistrictDto.setCity( dstDistrict.getCity() );

        return dstDistrictDto;
    }

    @Override
    public DstDistrict convertToDstDistrict(DstDistrictSaveRequestDto dstDistrictSaveRequestDto) {
        if ( dstDistrictSaveRequestDto == null ) {
            return null;
        }

        DstDistrict dstDistrict = new DstDistrict();

        dstDistrict.setDistrictName( dstDistrictSaveRequestDto.getDistrictName() );
        dstDistrict.setCity( ctyCitySaveRequestDtoToCtyCity( dstDistrictSaveRequestDto.getCity() ) );

        return dstDistrict;
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

    protected CtyCity ctyCitySaveRequestDtoToCtyCity(CtyCitySaveRequestDto ctyCitySaveRequestDto) {
        if ( ctyCitySaveRequestDto == null ) {
            return null;
        }

        CtyCity ctyCity = new CtyCity();

        ctyCity.setCityName( ctyCitySaveRequestDto.getCityName() );
        ctyCity.setPlateNumber( ctyCitySaveRequestDto.getPlateNumber() );
        ctyCity.setCountry( cntCountrySaveRequestDtoToCntCountry( ctyCitySaveRequestDto.getCountry() ) );

        return ctyCity;
    }
}
