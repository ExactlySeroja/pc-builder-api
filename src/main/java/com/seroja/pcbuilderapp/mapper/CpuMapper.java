package com.seroja.pcbuilderapp.mapper;


import com.seroja.pcbuilderapp.entities.Case;
import com.seroja.pcbuilderapp.entities.Cpu;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CpuMapper {

    void update(@MappingTarget Cpu entity, Cpu updateEntity);

}
