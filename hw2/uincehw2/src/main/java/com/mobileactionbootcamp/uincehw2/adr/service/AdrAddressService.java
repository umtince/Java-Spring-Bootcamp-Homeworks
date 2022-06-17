package com.mobileactionbootcamp.uincehw2.adr.service;

import com.mobileactionbootcamp.uincehw2.adr.converter.AdrAddressMapper;
import com.mobileactionbootcamp.uincehw2.adr.dao.AdrAddressDao;
import com.mobileactionbootcamp.uincehw2.adr.dto.AdrAddressDto;
import com.mobileactionbootcamp.uincehw2.adr.dto.AdrAddressSaveRequestByStreetDto;
import com.mobileactionbootcamp.uincehw2.adr.entity.AdrAddress;
import com.mobileactionbootcamp.uincehw2.gen.service.GenGeneralService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
@AllArgsConstructor
@Transactional
public class AdrAddressService {
    private AdrAddressDao adrAddressDao;
    private GenGeneralService genGeneralService;
    @PersistenceContext
    private EntityManager entityManager;
    public AdrAddressDto save(AdrAddressSaveRequestByStreetDto adrAddressSaveRequestByStreetDto){
        AdrAddress adrAddress = AdrAddressMapper.INSTANCE.convertToAdrAddress(adrAddressSaveRequestByStreetDto);

        adrAddress.setStreet(genGeneralService.findInDBAndAssignIds(adrAddress.getStreet()));
        adrAddress.setDoorNumber(adrAddressSaveRequestByStreetDto.getDoorNumber());
        adrAddress.setApartmentNumber(adrAddressSaveRequestByStreetDto.getApartmentNumber());
        adrAddress = assignForeignKeysToAddress(adrAddress);

        adrAddress = assignIdIfExist(adrAddress);

        //If adrAddress has an Id, (meaning it is already in the DB, it is not saved again.)
        if(adrAddress.getId() == null){
            adrAddress = entityManager.merge(adrAddress);
            adrAddress = adrAddressDao.save(adrAddress);
        }

        AdrAddressDto adrAddressDto = AdrAddressMapper.INSTANCE.convertToAdrAddressDto(adrAddress);
        return adrAddressDto;
    }

    private AdrAddress assignForeignKeysToAddress(AdrAddress adrAddress){

        /**
         * This method does the following:
         * It finds the Street object in adrAddress and assings the missing
         * fields (Country, City, District and Neighborhood).
         *
         * This is needed because adrAddressSaveRequestByStreetDto has only the street object.
         * However, adrAddress must have Country, City, District, Neighborhood and Street objects.
         * */

        adrAddress.setNeighborhood(adrAddress.getStreet().getNeighborhood());
        adrAddress.setDistrict(adrAddress.getNeighborhood().getDistrict());
        adrAddress.setCity(adrAddress.getDistrict().getCity());
        adrAddress.setCountry(adrAddress.getCity().getCountry());

        return adrAddress;
    }

    private AdrAddress assignIdIfExist(AdrAddress adrAddress){

        /**
         *This method checks if the newcoming address entry has already been
         *flushed to the database or not. If it has, it assigns the newcoming address
         * with the existing entry's Id.
         **/

        List<AdrAddress> adrAddressList = adrAddressDao.findAll();

        for(AdrAddress address : adrAddressList){
            if(adrAddress.getCountry().getId().equals(address.getCountry().getId())
            && adrAddress.getCity().getId().equals(address.getCity().getId())
            && adrAddress.getDistrict().getId().equals(address.getDistrict().getId())
            && adrAddress.getNeighborhood().getId().equals(address.getNeighborhood().getId())
            && adrAddress.getStreet().getId().equals(address.getStreet().getId())
            && adrAddress.getApartmentNumber().equals(address.getApartmentNumber())
            && adrAddress.getDoorNumber().equals(address.getDoorNumber())
            ){
                adrAddress.setId(address.getId());
            }
        }
        return adrAddress;
    }

    public AdrAddressDto getAddressById(Long id){
        AdrAddress adrAddress = adrAddressDao.findById(id).orElseThrow();

        AdrAddressDto adrAddressDto = AdrAddressMapper.INSTANCE.convertToAdrAddressDto(adrAddress);

        return adrAddressDto;
    }

    public AdrAddressDto deleteAddressById(Long id){
        AdrAddressDto adrAddressDto = getAddressById(id);
        adrAddressDao.deleteById(id);
        return adrAddressDto;
    }

}
