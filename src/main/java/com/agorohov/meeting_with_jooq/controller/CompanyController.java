package com.agorohov.meeting_with_jooq.controller;

import com.agorohov.jooq.generated.tables.pojos.Company;
import com.agorohov.meeting_with_jooq.dto.CompanyDto;
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
    public List<Company> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@Positive @PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Company create(@Valid @RequestBody CompanyDto companyDto) {
        Company company = new Company(null, companyDto.getName(), companyDto.getBudget());
        return service.create(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Positive @PathVariable Integer id, @Valid @RequestBody CompanyDto companyDto) {
        Company company = new Company(id, companyDto.getName(), companyDto.getBudget());
        service.update(company);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Positive @PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
