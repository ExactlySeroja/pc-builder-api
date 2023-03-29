package com.seroja.pcbuilderapp.mapper;

import com.seroja.pcbuilderapp.dto.AssembledDto;
import com.seroja.pcbuilderapp.entities.Assembled;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface AssembledMapper {
    @Mapping(source = "id", target = "assembledId")
    @Mapping(source = "cpu.id", target = "cpuId")
    @Mapping(source = "gpu.id", target = "gpuId")
    @Mapping(source = "caseField.id", target = "pcCaseId")
    @Mapping(source = "motherboard.id", target = "motherboardId")
    @Mapping(source = "ram.id", target = "ramId")
    @Mapping(source = "powerUnit.id", target = "powerUnitId")
    @Mapping(source = "drive.id", target = "driveId")
    AssembledDto toDto(Assembled assembled);

    @Mapping(source = "cpuId", target = "cpu.id")
    @Mapping(source = "gpuId", target = "gpu.id")
    @Mapping(source = "pcCaseId", target = "caseField.id")
    @Mapping(source = "motherboardId", target = "motherboard.id")
    @Mapping(source = "ramId", target = "ram.id")
    @Mapping(source = "powerUnitId", target = "powerUnit.id")
    @Mapping(source = "driveId", target = "drive.id")
    Assembled toAssembled(AssembledDto dto);

    List<Assembled> toList(List<AssembledDto> dtos);

    List<AssembledDto> toDTOList(List<Assembled> assembledList);

    @Mapping(ignore = true, source = "id", target = "id")
    void update(@MappingTarget Assembled entity, Assembled updateEntity);
}
