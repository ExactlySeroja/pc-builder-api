package com.seroja.pcbuilderapp.mapper;


import com.seroja.pcbuilderapp.entities.Case;
import com.seroja.pcbuilderapp.entities.Drive;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DriveMapper {

    void update(@MappingTarget Drive entity, Drive updateEntity);

}
