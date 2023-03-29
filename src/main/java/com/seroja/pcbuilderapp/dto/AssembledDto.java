package com.seroja.pcbuilderapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AssembledDto {
    @NotNull
    private int assembledId;
    @NotNull
    private int pcCaseId;
    @NotNull
    private int cpuId;
    @NotNull
    private int gpuId;
    @NotNull
    private int motherboardId;
    @NotNull
    private int powerUnitId;
    @NotNull
    private int ramId;
    @NotNull
    private int driveId;
    @Min(1)
    @NotNull
    private int ramAmount;
    @Min(1)
    @NotNull
    private int drivesAmount;
}
