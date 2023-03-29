package com.seroja.pcbuilderapp.mapper;

import com.seroja.pcbuilderapp.dto.CaseDto;
import com.seroja.pcbuilderapp.entities.Case;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CaseMapper {

    CaseDto toDto(Case pcCase);

    List<CaseDto> toDTOList(List<Case> caseDtoList);

    Case toCase(CaseDto dto);

    List<Case> toList(List<CaseDto> caseDtoList);

    @Mapping(ignore = true, source = "id", target = "id")
    void update(@MappingTarget Case entity, Case updateEntity);

}
