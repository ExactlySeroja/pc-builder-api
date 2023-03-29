package com.seroja.pcbuilderapp.mapper;


import com.seroja.pcbuilderapp.dto.DriveDto;
import com.seroja.pcbuilderapp.entities.Drive;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface DriveMapper {

    DriveDto toDto(Drive drive);

    Drive toDrive(DriveDto dto);

    List<DriveDto> toDtoList(List<Drive> driveList);

    List<Drive> toList(List<DriveDto> driveDtoList);

    @Mapping(ignore = true, source = "id", target = "id")
    void update(@MappingTarget Drive entity, Drive updateEntity);

}
