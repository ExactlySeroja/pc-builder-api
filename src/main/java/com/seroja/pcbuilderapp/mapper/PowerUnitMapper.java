package com.seroja.pcbuilderapp.mapper;

import com.seroja.pcbuilderapp.dto.PowerUnitDto;
import com.seroja.pcbuilderapp.entities.PowerUnit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface PowerUnitMapper {
    PowerUnitDto toDto(PowerUnit powerUnit);

    PowerUnit toPowerUnit(PowerUnitDto dto);

    List<PowerUnitDto> toDtoList(List<PowerUnit> powerUnitList);

    List<PowerUnit> toList(List<PowerUnitDto> powerUnitDtoList);

    @Mapping(ignore = true, source = "id", target = "id")
    void update(@MappingTarget PowerUnit entity, PowerUnit updateEntity);

}
