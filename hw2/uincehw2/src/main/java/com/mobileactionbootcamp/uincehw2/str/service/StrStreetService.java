package com.mobileactionbootcamp.uincehw2.str.service;

import com.mobileactionbootcamp.uincehw2.gen.service.GenGeneralService;
import com.mobileactionbootcamp.uincehw2.nei.dto.NeiNeighborhoodDto;
import com.mobileactionbootcamp.uincehw2.str.converter.StrStreetMapper;
import com.mobileactionbootcamp.uincehw2.str.dao.StrStreetDao;
import com.mobileactionbootcamp.uincehw2.str.dto.StrStreetDto;
import com.mobileactionbootcamp.uincehw2.str.dto.StrStreetSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.str.entity.StrStreet;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StrStreetService {

    private StrStreetDao strStreetDao;

    private GenGeneralService genGeneralService;

    public StrStreetDto save(StrStreetSaveRequestDto strStreetSaveRequestDto){
        StrStreet strStreet = StrStreetMapper.INSTANCE.convertToStrStreet(strStreetSaveRequestDto);
        strStreet = genGeneralService.findInDBAndAssignIds(strStreet);
        strStreet = strStreetDao.save(strStreet);
        StrStreetDto strStreetDto = StrStreetMapper.INSTANCE.convertToStrStreetDto(strStreet);

        return strStreetDto;
    }

    public List<StrStreetDto> findAll(){
        List<StrStreet> strStreetList = strStreetDao.findAll();
        List<StrStreetDto> strStreetDtoList = new ArrayList<>();

        for(StrStreet street : strStreetList){
            strStreetDtoList.add(StrStreetMapper.INSTANCE.convertToStrStreetDto(street));
        }
        return strStreetDtoList;
    }

    public StrStreetDto update(String oldName, String newName){
        List<StrStreetDto> strStreetDtoList = findAll();
        StrStreet strStreet;
        StrStreetDto strStreetDtoReturn;
        for(StrStreetDto strStreetDto : strStreetDtoList){
            if(strStreetDto.getStreetName().equals(oldName)){
                strStreet = StrStreetMapper.INSTANCE.convertToStrStreet(strStreetDto);
                strStreet.setStreetName(newName);
                strStreet = strStreetDao.save(strStreet);
                strStreetDtoReturn = StrStreetMapper.INSTANCE.convertToStrStreetDto(strStreet);
                return strStreetDtoReturn;
            }
        }

        return null;
    }

    public List<StrStreetDto> getStreetsByNeighborhood(String neighborhood){
        List<StrStreetDto> strStreetDtoList = findAll();
        List<StrStreetDto> strStreetDtoListReturn = new ArrayList<>();

        for(StrStreetDto streetDto : strStreetDtoList){
            if(streetDto.getNeighborhood().getNeighborhoodName().equals(neighborhood)){
                strStreetDtoListReturn.add(streetDto);
            }
        }

        return strStreetDtoListReturn;
    }
}
