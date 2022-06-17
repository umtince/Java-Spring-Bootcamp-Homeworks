package com.mobileactionbootcamp.uincehw2.cty.service;

import com.mobileactionbootcamp.uincehw2.cty.converter.CtyCityMapper;
import com.mobileactionbootcamp.uincehw2.cty.dao.CtyCityDao;
import com.mobileactionbootcamp.uincehw2.cty.dto.CtyCityDto;
import com.mobileactionbootcamp.uincehw2.cty.dto.CtyCitySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import com.mobileactionbootcamp.uincehw2.gen.service.GenGeneralService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CtyCityService {
    private CtyCityDao ctyCityDao;
    private GenGeneralService genGeneralService;

    public CtyCityDto save(CtyCitySaveRequestDto ctyCitySaveRequestDto){
        CtyCity ctyCity = CtyCityMapper.INSTANCE.convertToCtyCity(ctyCitySaveRequestDto);
        ctyCity = genGeneralService.findInDBAndAssignIds(ctyCity);
        ctyCity = ctyCityDao.save(ctyCity);
        CtyCityDto ctyCityDto = CtyCityMapper.INSTANCE.convertToCtyCityDto(ctyCity);

        return ctyCityDto;
    }

    public List<CtyCityDto> findAll(){
        List<CtyCity> ctyCity = ctyCityDao.findAll();
        List<CtyCityDto> ctyCityDtoList = new ArrayList<>();

        for (CtyCity city : ctyCity){
            ctyCityDtoList.add(CtyCityMapper.INSTANCE.convertToCtyCityDto(city));
        }

        return ctyCityDtoList;
    }
    public CtyCityDto findByPlateNumber(Long plateNumber){

        List<CtyCityDto> ctyCityDtoList = findAll();

        for (CtyCityDto cityDto : ctyCityDtoList){
            System.out.println(cityDto.getCityName() + "  " + cityDto.getPlateNumber() + "  " + cityDto.getCountry().getCountryName() + "   "+ cityDto.getCountry().getCountryCode());
            if(cityDto.getPlateNumber().equals(plateNumber)) {
                return cityDto;
            }
        }
        return null;
    }
}
