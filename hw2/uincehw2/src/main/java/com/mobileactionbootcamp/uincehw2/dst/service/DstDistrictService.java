package com.mobileactionbootcamp.uincehw2.dst.service;

import com.mobileactionbootcamp.uincehw2.dst.converter.DstDistrictMapper;
import com.mobileactionbootcamp.uincehw2.dst.dao.DstDistrictDao;
import com.mobileactionbootcamp.uincehw2.dst.dto.DstDistrictDto;
import com.mobileactionbootcamp.uincehw2.dst.dto.DstDistrictSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.dst.entity.DstDistrict;
import com.mobileactionbootcamp.uincehw2.gen.service.GenGeneralService;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DstDistrictService {
    private DstDistrictDao dstDistrictDao;
    private GenGeneralService genGeneralService;

    public DstDistrictDto save(DstDistrictSaveRequestDto dstDistrictSaveRequestDto){
        DstDistrict dstDistrict = DstDistrictMapper.INSTANCE.convertToDstDistrict(dstDistrictSaveRequestDto);
        dstDistrict = genGeneralService.findInDBAndAssignIds(dstDistrict);
        dstDistrict = dstDistrictDao.save(dstDistrict);
        DstDistrictDto dstDistrictDto = DstDistrictMapper.INSTANCE.convertToDstDistrictDto(dstDistrict);
        return dstDistrictDto;
    }

    public List<DstDistrictDto> findAll(){
        List<DstDistrictDto> dstDistrictDtoList = new ArrayList<>();

        List<DstDistrict> dstDistrictList = dstDistrictDao.findAll();

        for(DstDistrict dstDistrict : dstDistrictList){
            dstDistrictDtoList.add(DstDistrictMapper.INSTANCE.convertToDstDistrictDto(dstDistrict));
        }

        return dstDistrictDtoList;
    }

    public List<DstDistrictDto> getDistrictsByCity(String city){
        List<DstDistrictDto> districtsInCity = new ArrayList<>();
        List<DstDistrictDto> dstDistrictDtoList = findAll();

        for (DstDistrictDto dstDistrictDto : dstDistrictDtoList){
            if(dstDistrictDto.getCity().getCityName().equals(city)){
                districtsInCity.add(dstDistrictDto);
            }
        }
        return districtsInCity;
    }
}
