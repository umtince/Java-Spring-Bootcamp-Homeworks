package com.mobileactionbootcamp.uincehw2.adr.controller;

import com.mobileactionbootcamp.uincehw2.adr.dto.AdrAddressDto;
import com.mobileactionbootcamp.uincehw2.adr.dto.AdrAddressSaveRequestByStreetDto;
import com.mobileactionbootcamp.uincehw2.adr.service.AdrAddressService;
import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountryDto;
import com.mobileactionbootcamp.uincehw2.cnt.dto.CntCountrySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cnt.service.CntCountryService;
import com.mobileactionbootcamp.uincehw2.cty.dto.CtyCityDto;
import com.mobileactionbootcamp.uincehw2.cty.dto.CtyCitySaveRequestDto;
import com.mobileactionbootcamp.uincehw2.cty.service.CtyCityService;
import com.mobileactionbootcamp.uincehw2.dst.dto.DstDistrictDto;
import com.mobileactionbootcamp.uincehw2.dst.dto.DstDistrictSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.dst.service.DstDistrictService;
import com.mobileactionbootcamp.uincehw2.nei.dto.NeiNeighborhoodDto;
import com.mobileactionbootcamp.uincehw2.nei.dto.NeiNeighborhoodSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.nei.service.NeiNeighborhoodService;
import com.mobileactionbootcamp.uincehw2.str.dto.StrStreetDto;
import com.mobileactionbootcamp.uincehw2.str.dto.StrStreetSaveRequestDto;
import com.mobileactionbootcamp.uincehw2.str.service.StrStreetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor

public class AdrAddressController {

    private CntCountryService cntCountryService;
    private CtyCityService ctyCityService;
    private DstDistrictService dstDistrictService;
    private NeiNeighborhoodService neiNeighborhoodService;
    private StrStreetService strStreetService;
    private AdrAddressService adrAddressService;

    @PostMapping("/country")
    public ResponseEntity<CntCountryDto> save(@RequestBody CntCountrySaveRequestDto cntCountrySaveRequestDto){

        CntCountryDto cntCountryDto = cntCountryService.save(cntCountrySaveRequestDto);

        return ResponseEntity.ok(cntCountryDto);
    }

    @GetMapping("/country/{code}")
    public ResponseEntity<CntCountryDto> getCountryByCode(@RequestParam String code){

        CntCountryDto cntCountryDto = cntCountryService.findByCountryCode(code);

        if (cntCountryDto != null)
        {
            return ResponseEntity.ok(cntCountryDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/city")
    public ResponseEntity<CtyCityDto> save(@RequestBody CtyCitySaveRequestDto ctyCitySaveRequestDto){

        CtyCityDto ctyCityDto = ctyCityService.save(ctyCitySaveRequestDto);

        return ResponseEntity.ok(ctyCityDto);
    }

    @GetMapping("/city/{plateNumber}")
    public ResponseEntity<CtyCityDto> getCityByPlateNumber(@RequestParam Long plateNumber){
        CtyCityDto ctyCityDto = ctyCityService.findByPlateNumber(plateNumber);

        if(ctyCityDto != null) {
            return ResponseEntity.ok(ctyCityDto);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/district")
    public ResponseEntity<DstDistrictDto> save(@RequestBody DstDistrictSaveRequestDto dstDistrictSaveRequestDto){
        DstDistrictDto dstDistrictDto = dstDistrictService.save(dstDistrictSaveRequestDto);
        return ResponseEntity.ok(dstDistrictDto);
    }

    @GetMapping("/districts/{city}")
    public ResponseEntity<List<DstDistrictDto>> getDistrictByCity(@RequestParam String city){
        List<DstDistrictDto> dstDistrictDtoList = dstDistrictService.getDistrictsByCity(city);

        return ResponseEntity.ok(dstDistrictDtoList);
    }

    @PostMapping("/neighborhood")
    public ResponseEntity<NeiNeighborhoodDto> save(@RequestBody NeiNeighborhoodSaveRequestDto neiNeighborhoodSaveRequestDto){
        NeiNeighborhoodDto neiNeighborhoodDto = neiNeighborhoodService.save(neiNeighborhoodSaveRequestDto);

        return ResponseEntity.ok(neiNeighborhoodDto);
    }

    @PatchMapping("/neighborhood")
    public ResponseEntity<NeiNeighborhoodDto> updateNeighborhood(@RequestParam String oldName, String newName){
        NeiNeighborhoodDto neiNeighborhoodDto = neiNeighborhoodService.update(oldName, newName);

        if (neiNeighborhoodDto != null) {
            return ResponseEntity.ok(neiNeighborhoodDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/neighborhoods/{district}")
    public ResponseEntity<List<NeiNeighborhoodDto>> getNeighborhoodsByDistrict(@RequestParam String district){
        List<NeiNeighborhoodDto> neiNeighborhoodDtoList = neiNeighborhoodService.getNeighborhoodsByDistrict(district);

        return ResponseEntity.ok(neiNeighborhoodDtoList);
    }

    @PostMapping("/street")
    public ResponseEntity<StrStreetDto> save(@RequestBody StrStreetSaveRequestDto strStreetSaveRequestDto){
        StrStreetDto strStreetDto = strStreetService.save(strStreetSaveRequestDto);

        return ResponseEntity.ok(strStreetDto);
    }

    @PatchMapping("/street")
    public ResponseEntity<StrStreetDto> updateStreet(@RequestParam String oldName, String newName){
        StrStreetDto strStreetDto = strStreetService.update(oldName, newName);

        if(strStreetDto != null){
            return ResponseEntity.ok(strStreetDto);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/streets/{neighborhood}")
    public ResponseEntity<List<StrStreetDto>> getStreetsByNeighborhood(@RequestParam String neighborhood){
        List<StrStreetDto> strStreetDtoList = strStreetService.getStreetsByNeighborhood(neighborhood);

        return ResponseEntity.ok(strStreetDtoList);
    }

    @PostMapping("/address")
    public ResponseEntity<AdrAddressDto> save(@RequestBody AdrAddressSaveRequestByStreetDto adrAddressSaveRequestByStreetDto){
        AdrAddressDto adrAddressDto = adrAddressService.save(adrAddressSaveRequestByStreetDto);

        return ResponseEntity.ok(adrAddressDto);
    }

    @DeleteMapping("/address/id/{id}")
    public ResponseEntity<AdrAddressDto> deleteAddressById(@RequestParam Long id){
        AdrAddressDto adrAddressDto = adrAddressService.deleteAddressById(id);

        return ResponseEntity.ok(adrAddressDto);
    }

    @GetMapping("/address/id/{id}")
    public ResponseEntity<AdrAddressDto> getAddressById(@RequestParam Long id){
        AdrAddressDto adrAddressDto = adrAddressService.getAddressById(id);

        return ResponseEntity.ok(adrAddressDto);
    }

}
