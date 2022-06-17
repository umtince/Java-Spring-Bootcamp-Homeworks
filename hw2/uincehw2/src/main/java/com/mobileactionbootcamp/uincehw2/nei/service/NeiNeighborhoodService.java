package com.mobileactionbootcamp.uincehw2.nei.service;

import com.mobileactionbootcamp.uincehw2.gen.service.GenGeneralService;
import com.mobileactionbootcamp.uincehw2.nei.converter.NeiNeighborhoodMapper;
import com.mobileactionbootcamp.uincehw2.nei.dao.NeiNeighborhoodDao;
import com.mobileactionbootcamp.uincehw2.nei.dto.NeiNeighborhoodDto;
import com.mobileactionbootcamp.uincehw2.nei.entity.NeiNeighborhood;
import com.mobileactionbootcamp.uincehw2.nei.dto.NeiNeighborhoodSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NeiNeighborhoodService {
    private NeiNeighborhoodDao neiNeighborhoodDao;
    private GenGeneralService genGeneralService;

    public NeiNeighborhoodDto save(NeiNeighborhoodSaveRequestDto neiNeighborhoodSaveRequestDto){
        NeiNeighborhood neiNeighborhood = NeiNeighborhoodMapper.INSTANCE.convertToNeiNeighborhood(neiNeighborhoodSaveRequestDto);
        neiNeighborhood = genGeneralService.findInDBAndAssignIds(neiNeighborhood);
        neiNeighborhood = neiNeighborhoodDao.save(neiNeighborhood);
        NeiNeighborhoodDto neiNeighborhoodDto = NeiNeighborhoodMapper.INSTANCE.convertToNeiNeighborhoodDto(neiNeighborhood);

        return neiNeighborhoodDto;
    }

    public List<NeiNeighborhoodDto> findAll(){
        List<NeiNeighborhood> neiNeighborhoodList = neiNeighborhoodDao.findAll();
        List<NeiNeighborhoodDto> neiNeighborhoodDtoList = new ArrayList<>();
        for(NeiNeighborhood neiNeighborhood : neiNeighborhoodList){
            neiNeighborhoodDtoList.add(NeiNeighborhoodMapper.INSTANCE.convertToNeiNeighborhoodDto(neiNeighborhood));
        }
        return neiNeighborhoodDtoList;
    }
    public NeiNeighborhoodDto update(String oldName, String newName){
        List<NeiNeighborhoodDto> neiNeighborhoodDtoList = findAll();
        NeiNeighborhood neiNeighborhood;
        NeiNeighborhoodDto neiNeighborhoodDtoReturn;

        for(NeiNeighborhoodDto neiNeighborhoodDto : neiNeighborhoodDtoList){
            if(neiNeighborhoodDto.getNeighborhoodName().equals(oldName)){
                neiNeighborhoodDto.setNeighborhoodName(newName);
                neiNeighborhood = NeiNeighborhoodMapper.INSTANCE.convertToNeiNeighborhood(neiNeighborhoodDto);
                neiNeighborhood = neiNeighborhoodDao.save(neiNeighborhood);

                neiNeighborhoodDtoReturn = NeiNeighborhoodMapper.INSTANCE.convertToNeiNeighborhoodDto(neiNeighborhood);
                return  neiNeighborhoodDtoReturn;
            }
        }
        return null;
    }

    public List<NeiNeighborhoodDto> getNeighborhoodsByDistrict(String district){
        List<NeiNeighborhoodDto> neiNeighborhoodDtoList = findAll();
        List<NeiNeighborhoodDto> neiNeighborhoodDtosByDistrict = new ArrayList<>();
        for(NeiNeighborhoodDto neighborhoodDto : neiNeighborhoodDtoList){
            if(neighborhoodDto.getDistrict().getDistrictName().equals(district)){
                neiNeighborhoodDtosByDistrict.add(neighborhoodDto);
            }
        }
        return neiNeighborhoodDtosByDistrict;
    }
}
