package com.mobileactionbootcamp.uincehw2.nei.converter;

import com.mobileactionbootcamp.uincehw2.nei.dto.NeiNeighborhoodDto;
import com.mobileactionbootcamp.uincehw2.nei.entity.NeiNeighborhood;
import com.mobileactionbootcamp.uincehw2.nei.dto.NeiNeighborhoodSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NeiNeighborhoodMapper {
    NeiNeighborhoodMapper INSTANCE = Mappers.getMapper(NeiNeighborhoodMapper.class);

    NeiNeighborhoodDto convertToNeiNeighborhoodDto(NeiNeighborhood neiNeighborhood);
    NeiNeighborhood convertToNeiNeighborhood(NeiNeighborhoodSaveRequestDto neiNeighborhoodSaveRequestDto);
    NeiNeighborhood convertToNeiNeighborhood(NeiNeighborhoodDto neiNeighborhoodDto);

}
