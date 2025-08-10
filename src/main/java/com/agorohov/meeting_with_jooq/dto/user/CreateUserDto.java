package com.agorohov.meeting_with_jooq.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CreateUserDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Age must be positive")
    private Integer age;

    @Positive(message = "Company ID must be positive")
    private Integer companyId;

    public CreateUserDto() {
    }

    public CreateUserDto(String name, Integer age, Integer companyId) {
        this.name = name;
        this.age = age;
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
