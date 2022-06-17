package com.mobileactionbootcamp.uincehw2.nei.converter;

import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountrySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import com.mobileactionbootcamp.uincehw2.cty.dto.CtyCitySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import com.mobileactionbootcamp.uincehw2.dst.dto.DstDistrictSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.dst.entity.DstDistrict;
import com.mobileactionbootcamp.uincehw2.nei.dto.NeiNeighborhoodDto;
import com.mobileactionbootcamp.uincehw2.nei.dto.NeiNeighborhoodSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.nei.entity.NeiNeighborhood;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-13T00:59:07+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class NeiNeighborhoodMapperImpl implements NeiNeighborhoodMapper {

    @Override
    public NeiNeighborhoodDto convertToNeiNeighborhoodDto(NeiNeighborhood neiNeighborhood) {
        if ( neiNeighborhood == null ) {
            return null;
        }

        NeiNeighborhoodDto neiNeighborhoodDto = new NeiNeighborhoodDto();

        neiNeighborhoodDto.setId( neiNeighborhood.getId() );
        neiNeighborhoodDto.setNeighborhoodName( neiNeighborhood.getNeighborhoodName() );
        neiNeighborhoodDto.setDistrict( neiNeighborhood.getDistrict() );

        return neiNeighborhoodDto;
    }

    @Override
    public NeiNeighborhood convertToNeiNeighborhood(NeiNeighborhoodSaveRequestDto neiNeighborhoodSaveRequestDto) {
        if ( neiNeighborhoodSaveRequestDto == null ) {
            return null;
        }

        NeiNeighborhood neiNeighborhood = new NeiNeighborhood();

        neiNeighborhood.setNeighborhoodName( neiNeighborhoodSaveRequestDto.getNeighborhoodName() );
        neiNeighborhood.setDistrict( dstDistrictSaveRequestDtoToDstDistrict( neiNeighborhoodSaveRequestDto.getDistrict() ) );

        return neiNeighborhood;
    }

    @Override
    public NeiNeighborhood convertToNeiNeighborhood(NeiNeighborhoodDto neiNeighborhoodDto) {
        if ( neiNeighborhoodDto == null ) {
            return null;
        }

        NeiNeighborhood neiNeighborhood = new NeiNeighborhood();

        neiNeighborhood.setId( neiNeighborhoodDto.getId() );
        neiNeighborhood.setNeighborhoodName( neiNeighborhoodDto.getNeighborhoodName() );
        neiNeighborhood.setDistrict( neiNeighborhoodDto.getDistrict() );

        return neiNeighborhood;
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
}
