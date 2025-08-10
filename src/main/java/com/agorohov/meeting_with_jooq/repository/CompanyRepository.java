package com.agorohov.meeting_with_jooq.repository;

import com.agorohov.jooq.generated.tables.pojos.Company;
import com.agorohov.jooq.generated.tables.records.CompanyRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.agorohov.jooq.generated.tables.Company.COMPANY;

@Repository
public class CompanyRepository {

    private final DSLContext dsl;

    public CompanyRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<Company> findAll() {
        return dsl.selectFrom(COMPANY)
                .fetchInto(Company.class);
    }

    public Optional<Company> findById(Integer id) {
        return dsl.selectFrom(COMPANY)
                .where(COMPANY.ID.eq(id))
                .fetchOptionalInto(Company.class);
    }

    public Company create(Company company) {
        CompanyRecord record = dsl.newRecord(COMPANY);
        record.setName(company.getName());
        record.setBudget(company.getBudget());
        record.store();
        return record.into(Company.class);
    }

    public void update(Company company) {
        dsl.update(COMPANY)
                .set(COMPANY.NAME, company.getName())
                .set(COMPANY.BUDGET, company.getBudget())
                .where(COMPANY.ID.eq(company.getId()))
                .execute();
    }

    public void delete(Integer id) {
        dsl.deleteFrom(COMPANY)
                .where(COMPANY.ID.eq(id))
                .execute();
    }
}
