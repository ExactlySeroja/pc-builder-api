package com.seroja.pcbuilderapp.mapper;

import com.seroja.pcbuilderapp.entities.Case;
import com.seroja.pcbuilderapp.entities.PowerUnit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface PowerUnitMapper {

    void update(@MappingTarget PowerUnit entity, PowerUnit updateEntity);

}
