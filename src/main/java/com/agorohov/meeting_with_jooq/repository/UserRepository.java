package com.agorohov.meeting_with_jooq.repository;

import com.agorohov.jooq.generated.tables.pojos.Users;
import com.agorohov.jooq.generated.tables.records.UsersRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.agorohov.jooq.generated.tables.Users.USERS;

@Repository
public class UserRepository {

    private final DSLContext dsl;

    public UserRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<Users> findAll() {
        return dsl.selectFrom(USERS)
                .fetchInto(Users.class);
    }

    public Optional<Users> findById(Integer id) {
        return dsl.selectFrom(USERS)
                .where(USERS.ID.eq(id))
                .fetchOptionalInto(Users.class);
    }

    public Users create(Users user) {
        UsersRecord record = dsl.newRecord(USERS);
        record.setName(user.getName());
        record.setAge(user.getAge());
        record.setCompanyId(user.getCompanyId());
        record.store();
        return record.into(Users.class);
    }

    public void update(Users user) {
        dsl.update(USERS)
                .set(USERS.NAME, user.getName())
                .set(USERS.AGE, user.getAge())
                .set(USERS.COMPANY_ID, user.getCompanyId())
                .where(USERS.ID.eq(user.getId()))
                .execute();
    }

    public void delete(Integer id) {
        dsl.deleteFrom(USERS)
                .where(USERS.ID.eq(id))
                .execute();
    }
}
