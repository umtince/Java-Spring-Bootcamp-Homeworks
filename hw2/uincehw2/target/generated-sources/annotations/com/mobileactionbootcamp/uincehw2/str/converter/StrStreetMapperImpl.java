package com.mobileactionbootcamp.uincehw2.str.converter;

import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountrySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import com.mobileactionbootcamp.uincehw2.cty.dto.CtyCitySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import com.mobileactionbootcamp.uincehw2.dst.dto.DstDistrictSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.dst.entity.DstDistrict;
import com.mobileactionbootcamp.uincehw2.nei.dto.NeiNeighborhoodSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.nei.entity.NeiNeighborhood;
import com.mobileactionbootcamp.uincehw2.str.dto.StrStreetDto;
import com.mobileactionbootcamp.uincehw2.str.dto.StrStreetSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.str.entity.StrStreet;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-13T00:59:07+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class StrStreetMapperImpl implements StrStreetMapper {

    @Override
    public StrStreetDto convertToStrStreetDto(StrStreet strStreet) {
        if ( strStreet == null ) {
            return null;
        }

        StrStreetDto strStreetDto = new StrStreetDto();

        strStreetDto.setId( strStreet.getId() );
        strStreetDto.setStreetName( strStreet.getStreetName() );
        strStreetDto.setNeighborhood( strStreet.getNeighborhood() );

        return strStreetDto;
    }

    @Override
    public StrStreet convertToStrStreet(StrStreetSaveRequestDto strStreetSaveRequestDto) {
        if ( strStreetSaveRequestDto == null ) {
            return null;
        }

        StrStreet strStreet = new StrStreet();

        strStreet.setStreetName( strStreetSaveRequestDto.getStreetName() );
        strStreet.setNeighborhood( neiNeighborhoodSaveRequestDtoToNeiNeighborhood( strStreetSaveRequestDto.getNeighborhood() ) );

        return strStreet;
    }

    @Override
    public StrStreet convertToStrStreet(StrStreetDto strStreetDto) {
        if ( strStreetDto == null ) {
            return null;
        }

        StrStreet strStreet = new StrStreet();

        strStreet.setId( strStreetDto.getId() );
        strStreet.setStreetName( strStreetDto.getStreetName() );
        strStreet.setNeighborhood( strStreetDto.getNeighborhood() );

        return strStreet;
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

    protected DstDistrict dstDistrictSaveRequestDtoToDstDistrict(DstDistrictSaveRequestDto dstDistrictSaveRequestDto) {
        if ( dstDistrictSaveRequestDto == null ) {
            return null;
        }

        DstDistrict dstDistrict = new DstDistrict();

        dstDistrict.setDistrictName( dstDistrictSaveRequestDto.getDistrictName() );
        dstDistrict.setCity( ctyCitySaveRequestDtoToCtyCity( dstDistrictSaveRequestDto.getCity() ) );

        return dstDistrict;
    }

    protected NeiNeighborhood neiNeighborhoodSaveRequestDtoToNeiNeighborhood(NeiNeighborhoodSaveRequestDto neiNeighborhoodSaveRequestDto) {
        if ( neiNeighborhoodSaveRequestDto == null ) {
            return null;
        }

        NeiNeighborhood neiNeighborhood = new NeiNeighborhood();

        neiNeighborhood.setNeighborhoodName( neiNeighborhoodSaveRequestDto.getNeighborhoodName() );
        neiNeighborhood.setDistrict( dstDistrictSaveRequestDtoToDstDistrict( neiNeighborhoodSaveRequestDto.getDistrict() ) );

        return neiNeighborhood;
    }
}
