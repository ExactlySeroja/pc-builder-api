package com.seroja.pcbuilderapp.dto;

import jakarta.validation.constraints.Min;

public record PcBudgetRequest(@Min(1) int budget, @Min(1) int ramAmount, @Min(1) int drivesAmount) {
}
