package com.agorohov.meeting_with_jooq.dto.user;

public class UserWithCompanyNameResponseDto {

    private Integer id;
    private String name;
    private Integer age;
    private Integer companyId;
    private String companyName;

    public UserWithCompanyNameResponseDto() {
    }

    public UserWithCompanyNameResponseDto(
            Integer id,
            String name,
            Integer age,
            Integer companyId,
            String companyName
    ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.companyId = companyId;
        this.companyName = companyName;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
