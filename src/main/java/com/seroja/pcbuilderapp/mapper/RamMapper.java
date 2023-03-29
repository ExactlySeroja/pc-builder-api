package com.seroja.pcbuilderapp.mapper;


import com.seroja.pcbuilderapp.dto.RamDto;
import com.seroja.pcbuilderapp.entities.Ram;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface RamMapper {
    RamDto toDto(Ram ram);

    Ram toRam(RamDto ramDto);

    List<RamDto> toDtoList(List<Ram> ramList);

    List<Ram> toList(List<RamDto> ramDtoList);

    @Mapping(ignore = true, source = "id", target = "id")
    void update(@MappingTarget Ram entity, Ram updateEntity);

}
