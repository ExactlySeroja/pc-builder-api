package com.seroja.pcbuilderapp.mapper;

import com.seroja.pcbuilderapp.entities.Case;
import com.seroja.pcbuilderapp.entities.Motherboard;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface MotherboardMapper {

    void update(@MappingTarget Motherboard entity, Motherboard updateEntity);

}
