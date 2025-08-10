package com.agorohov.meeting_with_jooq.service;

import com.agorohov.jooq.generated.tables.pojos.Company;
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

    public List<Company> getAll() {
        return repository.findAll();
    }

    public Optional<Company> getById(Integer id) {
        return repository.findById(id);
    }

    public Company create(Company company) {
        return repository.create(company);
    }

    public void update(Company company) {
        repository.update(company);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }
}
