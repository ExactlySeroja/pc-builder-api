package com.seroja.pcbuilderapp.mapper;


import com.seroja.pcbuilderapp.dto.GpuDto;
import com.seroja.pcbuilderapp.entities.Gpu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface GpuMapper {
    GpuDto toDto(Gpu gpu);

    Gpu toGpu(GpuDto dto);

    List<GpuDto> toDtoList(List<Gpu> gpuList);

    List<Gpu> toList(List<GpuDto> gpuDtoList);

    @Mapping(ignore = true, source = "id", target = "id")
    void update(@MappingTarget Gpu entity, Gpu updateEntity);

}
