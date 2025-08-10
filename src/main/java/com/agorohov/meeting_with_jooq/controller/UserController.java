package com.agorohov.meeting_with_jooq.controller;

import com.agorohov.meeting_with_jooq.dto.user.CreateUserDto;
import com.agorohov.meeting_with_jooq.dto.user.UpdateUserDto;
import com.agorohov.meeting_with_jooq.dto.user.UserResponseDto;
import com.agorohov.meeting_with_jooq.dto.user.UserWithCompanyNameResponseDto;
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
    public List<UserResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@Positive @PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/with-company-name")
    public ResponseEntity<UserWithCompanyNameResponseDto> getByIdWithCompanyName(@Positive @PathVariable Integer id) {
        return service.getByIdWithCompanyName(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserResponseDto create(@Valid @RequestBody CreateUserDto userDto) {
        return service.create(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @Positive @PathVariable Integer id,
            @Valid @RequestBody UpdateUserDto userDto
    ) {
        userDto.setId(id);
        service.update(userDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Positive @PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
