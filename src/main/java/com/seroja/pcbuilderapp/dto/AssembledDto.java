package com.seroja.pcbuilderapp.dto;

import com.seroja.pcbuilderapp.entities.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AssembledDto{

    int assembledId;
    int pcCaseId;
    int cpuId;
    int gpuId;
    int motherboardId;
    int powerUnitId;
    int ramId;
    int driveId;
    int ramAmount;
    int drivesAmount;

}
