package com.agorohov.meeting_with_jooq.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class UpdateUserDto {

    @Positive(message = "ID is required")
    private Integer id;

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Age must be positive")
    private Integer age;

    @Positive(message = "Company ID must be positive")
    private Integer companyId;

    public UpdateUserDto() {
    }

    public UpdateUserDto(Integer id, String name, Integer age, Integer companyId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.companyId = companyId;
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
