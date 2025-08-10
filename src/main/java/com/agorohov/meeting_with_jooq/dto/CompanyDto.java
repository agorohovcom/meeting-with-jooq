package com.agorohov.meeting_with_jooq.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class CompanyDto {

    private Integer id;

    @NotBlank(message = "Name is required")
    private String name;

    @PositiveOrZero(message = "Budget must be non-negative")
    private BigDecimal budget;

    public CompanyDto() {
    }

    public CompanyDto(Integer id, String name, BigDecimal budget) {
        this.id = id;
        this.name = name;
        this.budget = budget;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
