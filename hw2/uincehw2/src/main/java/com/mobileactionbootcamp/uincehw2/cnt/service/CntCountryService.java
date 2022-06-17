package com.mobileactionbootcamp.uincehw2.cnt.service;

import com.mobileactionbootcamp.uincehw2.cnt.converter.CntCountryMapper;
import com.mobileactionbootcamp.uincehw2.cnt.dao.CntCountryDao;
import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountryDto;
import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountrySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CntCountryService {

    private CntCountryDao countryDao;

    public CntCountryDto save(CntCountrySaveRequestDto cntCountrySaveRequestDto){

        CntCountry cntCountry = CntCountryMapper.INSTANCE.convertToCntCountry(cntCountrySaveRequestDto);
        cntCountry = countryDao.save(cntCountry);
        CntCountryDto cntCountryDto = CntCountryMapper.INSTANCE.convertToCntCountryDto(cntCountry);
        return cntCountryDto;
    }

    public List<CntCountryDto> findAll(){
       List<CntCountry> cntCountryList = countryDao.findAll();
       List<CntCountryDto> cntCountryDtoList = new ArrayList<>();

        for (CntCountry country : cntCountryList) {
            cntCountryDtoList.add(CntCountryMapper.INSTANCE.convertToCntCountryDto(country));
        }
        return cntCountryDtoList;
    }
    public CntCountryDto findByCountryCode(String code){

        List<CntCountryDto> cntCountryDtoList = findAll();

        for (CntCountryDto countryDto : cntCountryDtoList){
            if(countryDto.getCountryCode().equals(code)){
                return countryDto;
            }
        }
        return null;
    }
}
