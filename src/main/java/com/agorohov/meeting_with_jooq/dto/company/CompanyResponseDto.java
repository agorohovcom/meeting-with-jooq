package com.agorohov.meeting_with_jooq.dto.company;

import java.math.BigDecimal;

public class CompanyResponseDto {

    private Integer id;
    private String name;
    private BigDecimal budget;

    public CompanyResponseDto() {
    }

    public CompanyResponseDto(Integer id, String name, BigDecimal budget) {
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
