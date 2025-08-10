package com.agorohov.meeting_with_jooq.service;

import com.agorohov.jooq.generated.tables.pojos.Users;
import com.agorohov.meeting_with_jooq.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<Users> getAll() {
        return repository.findAll();
    }

    public Optional<Users> getById(Integer id) {
        return repository.findById(id);
    }

    public Users create(Users user) {
        return repository.create(user);
    }

    public void update(Users user) {
        repository.update(user);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }
}
