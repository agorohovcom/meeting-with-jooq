package com.agorohov.meeting_with_jooq.controller;

import com.agorohov.meeting_with_jooq.dto.company.CompanyResponseDto;
import com.agorohov.meeting_with_jooq.dto.company.CreateCompanyDto;
import com.agorohov.meeting_with_jooq.dto.company.UpdateCompanyDto;
import com.agorohov.meeting_with_jooq.service.CompanyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public List<CompanyResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponseDto> getById(@Positive @PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CompanyResponseDto create(@Valid @RequestBody CreateCompanyDto companyDto) {
        return service.create(companyDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @Positive @PathVariable Integer id,
            @Valid @RequestBody UpdateCompanyDto companyDto
    ) {
        companyDto.setId(id);
        service.update(companyDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Positive @PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
