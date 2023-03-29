package com.seroja.pcbuilderapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.seroja.pcbuilderapp.entities.Cpu} entity
 */
@Data
public class CpuDto implements Serializable {
    private Integer id;
    @Size(max = 50)
    @NotNull
    private String name;
    @NotNull
    @Min(1)
    private Integer price;
    @NotNull
    private String socket;
}