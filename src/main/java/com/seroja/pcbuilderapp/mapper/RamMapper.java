package com.seroja.pcbuilderapp.mapper;


import com.seroja.pcbuilderapp.entities.Case;
import com.seroja.pcbuilderapp.entities.Ram;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RamMapper {

    void update(@MappingTarget Ram entity, Ram updateEntity);

}
