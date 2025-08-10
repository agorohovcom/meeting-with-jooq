package com.agorohov.meeting_with_jooq.service;

import com.agorohov.jooq.generated.tables.pojos.Users;
import com.agorohov.meeting_with_jooq.dto.user.CreateUserDto;
import com.agorohov.meeting_with_jooq.dto.user.UpdateUserDto;
import com.agorohov.meeting_with_jooq.dto.user.UserResponseDto;
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

    public List<UserResponseDto> getAll() {
        return repository.findAll().stream()
                .map(e -> new UserResponseDto(
                                e.getId(),
                                e.getName(),
                                e.getAge(),
                                e.getCompanyId()
                        )
                )
                .toList();
    }

    public Optional<UserResponseDto> getById(Integer id) {
        return repository.findById(id)
                .map(e -> new UserResponseDto(
                                e.getId(),
                                e.getName(),
                                e.getAge(),
                                e.getCompanyId()
                        )
                );
    }

    public UserResponseDto create(CreateUserDto userDto) {
        Users user = new Users(null, userDto.getName(), userDto.getAge(), userDto.getCompanyId());
        Users userResponse = repository.create(user);
        return new UserResponseDto(
                userResponse.getId(),
                userResponse.getName(),
                userResponse.getAge(),
                userResponse.getCompanyId()
        );
    }

    public void update(UpdateUserDto userDto) {
        Users user = new Users(userDto.getId(), userDto.getName(), userDto.getAge(), userDto.getCompanyId());
        repository.update(user);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }
}
