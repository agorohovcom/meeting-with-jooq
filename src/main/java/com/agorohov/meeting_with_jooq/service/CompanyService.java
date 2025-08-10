package com.agorohov.meeting_with_jooq.service;

import com.agorohov.jooq.generated.tables.pojos.Company;
import com.agorohov.meeting_with_jooq.dto.company.CompanyResponseDto;
import com.agorohov.meeting_with_jooq.dto.company.CreateCompanyDto;
import com.agorohov.meeting_with_jooq.dto.company.UpdateCompanyDto;
import com.agorohov.meeting_with_jooq.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<CompanyResponseDto> getAll() {
        return repository.findAll().stream()
                .map(e -> new CompanyResponseDto(
                        e.getId(),
                        e.getName(),
                        e.getBudget()
                ))
                .toList();
    }

    public Optional<CompanyResponseDto> getById(Integer id) {
        return repository.findById(id)
                .map(e -> new CompanyResponseDto(
                        e.getId(),
                        e.getName(),
                        e.getBudget()
                ));
    }

    public CompanyResponseDto create(CreateCompanyDto companyDto) {
        Company company = new Company(null, companyDto.getName(), companyDto.getBudget());
        Company companyResponse = repository.create(company);
        return new CompanyResponseDto(
                companyResponse.getId(),
                companyResponse.getName(),
                companyResponse.getBudget()
        );
    }

    public void update(UpdateCompanyDto companyDto) {
        Company company = new Company(companyDto.getId(), companyDto.getName(), companyDto.getBudget());
        repository.update(company);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }
}
