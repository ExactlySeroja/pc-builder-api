package com.seroja.pcbuilderapp.mapper;

import com.seroja.pcbuilderapp.entities.Assembled;
import com.seroja.pcbuilderapp.entities.Case;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper( componentModel = "spring")
@Component
public interface CaseMapper {

    void update(@MappingTarget Case entity, Case updateEntity);

}
