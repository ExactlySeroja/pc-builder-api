package com.seroja.pcbuilderapp.dto;

import com.seroja.pcbuilderapp.entities.Gpu;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Gpu} entity
 */
@Data
public class GpuDto implements Serializable {
    private Integer id;
    @Size(max = 50)
    @NotNull
    private String name;
    @NotNull
    @Min(1)
    private Integer price;
}