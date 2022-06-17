package com.mobileactionbootcamp.uincehw2.adr.converter;

import com.mobileactionbootcamp.uincehw2.adr.dto.AdrAddressDto;
import com.mobileactionbootcamp.uincehw2.adr.dto.AdrAddressSaveRequestByStreetDto;
import com.mobileactionbootcamp.uincehw2.adr.entity.AdrAddress;
import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountrySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import com.mobileactionbootcamp.uincehw2.cty.dto.CtyCitySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import com.mobileactionbootcamp.uincehw2.dst.dto.DstDistrictSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.dst.entity.DstDistrict;
import com.mobileactionbootcamp.uincehw2.nei.dto.NeiNeighborhoodSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.nei.entity.NeiNeighborhood;
import com.mobileactionbootcamp.uincehw2.str.dto.StrStreetSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.str.entity.StrStreet;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-13T02:39:08+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class AdrAddressMapperImpl implements AdrAddressMapper {

    @Override
    public AdrAddress convertToAdrAddress(AdrAddressSaveRequestByStreetDto adrAddressSaveRequestByStreetDto) {
        if ( adrAddressSaveRequestByStreetDto == null ) {
            return null;
        }

        AdrAddress adrAddress = new AdrAddress();

        adrAddress.setStreet( strStreetSaveRequestDtoToStrStreet( adrAddressSaveRequestByStreetDto.getStreet() ) );
        adrAddress.setApartmentNumber( adrAddressSaveRequestByStreetDto.getApartmentNumber() );
        adrAddress.setDoorNumber( adrAddressSaveRequestByStreetDto.getDoorNumber() );

        return adrAddress;
    }

    @Override
    public AdrAddressDto convertToAdrAddressDto(AdrAddress adrAddress) {
        if ( adrAddress == null ) {
            return null;
        }

        AdrAddressDto adrAddressDto = new AdrAddressDto();

        adrAddressDto.setId( adrAddress.getId() );
        adrAddressDto.setCountry( adrAddress.getCountry() );
        adrAddressDto.setCity( adrAddress.getCity() );
        adrAddressDto.setDistrict( adrAddress.getDistrict() );
        adrAddressDto.setNeighborhood( adrAddress.getNeighborhood() );
        adrAddressDto.setStreet( adrAddress.getStreet() );
        adrAddressDto.setApartmentNumber( adrAddress.getApartmentNumber() );
        adrAddressDto.setDoorNumber( adrAddress.getDoorNumber() );

        return adrAddressDto;
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

    protected StrStreet strStreetSaveRequestDtoToStrStreet(StrStreetSaveRequestDto strStreetSaveRequestDto) {
        if ( strStreetSaveRequestDto == null ) {
            return null;
        }

        StrStreet strStreet = new StrStreet();

        strStreet.setStreetName( strStreetSaveRequestDto.getStreetName() );
        strStreet.setNeighborhood( neiNeighborhoodSaveRequestDtoToNeiNeighborhood( strStreetSaveRequestDto.getNeighborhood() ) );

        return strStreet;
    }
}
