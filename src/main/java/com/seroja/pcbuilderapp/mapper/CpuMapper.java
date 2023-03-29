package com.seroja.pcbuilderapp.mapper;


import com.seroja.pcbuilderapp.dto.CpuDto;
import com.seroja.pcbuilderapp.entities.Cpu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CpuMapper {

    CpuDto toDto(Cpu cpu);

    Cpu toCpu(CpuDto dto);

    List<CpuDto> toDtoList(List<Cpu> cpuList);

    List<Cpu> toList(List<CpuDto> cpuDtoList);

    @Mapping(ignore = true, source = "id", target = "id")
    void update(@MappingTarget Cpu entity, Cpu updateEntity);

}
