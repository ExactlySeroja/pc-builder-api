package com.seroja.pcbuilderapp.mapper;

import com.seroja.pcbuilderapp.dto.MotherboardDto;
import com.seroja.pcbuilderapp.entities.Motherboard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface MotherboardMapper {

    MotherboardDto toDto(Motherboard motherboard);

    Motherboard toMotherboard(MotherboardDto dto);

    List<MotherboardDto> toDtoList(List<Motherboard> motherboardList);

    List<Motherboard> toList(List<MotherboardDto> motherboardDtoList);

    @Mapping(ignore = true, source = "id", target = "id")
    void update(@MappingTarget Motherboard entity, Motherboard updateEntity);

}
