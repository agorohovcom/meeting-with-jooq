package com.agorohov.meeting_with_jooq.controller;

import com.agorohov.jooq.generated.tables.pojos.Users;
import com.agorohov.meeting_with_jooq.dto.UserDto;
import com.agorohov.meeting_with_jooq.service.UserService;
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
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<Users> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getById(@Positive @PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Users create(@Valid @RequestBody UserDto userDto) {
        Users user = new Users(null, userDto.getName(), userDto.getAge(), userDto.getCompanyId());
        return service.create(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Positive @PathVariable Integer id, @Valid @RequestBody UserDto userDto) {
        Users user = new Users(id, userDto.getName(), userDto.getAge(), userDto.getCompanyId());
        service.update(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Positive @PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
