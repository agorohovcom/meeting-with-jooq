package com.agorohov.meeting_with_jooq.dto.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class CreateCompanyDto {

    @NotBlank(message = "Name is required")
    private String name;

    @PositiveOrZero(message = "Budget must be non-negative")
    private BigDecimal budget;

    public CreateCompanyDto() {
    }

    public CreateCompanyDto(String name, BigDecimal budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
