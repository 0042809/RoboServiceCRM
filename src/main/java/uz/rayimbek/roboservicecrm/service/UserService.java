package uz.rayimbek.roboservicecrm.service;

import uz.rayimbek.roboservicecrm.dto.UserRequestDto;
import uz.rayimbek.roboservicecrm.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto create(UserRequestDto dto);
    UserResponseDto getById(Long id);
    List<UserResponseDto> getAll();
    UserResponseDto update(Long id, UserRequestDto dto);
    void delete(Long id);
}
