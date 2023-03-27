package com.seroja.pcbuilderapp.mapper;


import com.seroja.pcbuilderapp.entities.Case;
import com.seroja.pcbuilderapp.entities.Gpu;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface GpuMapper {

    void update(@MappingTarget Gpu entity, Gpu updateEntity);

}
