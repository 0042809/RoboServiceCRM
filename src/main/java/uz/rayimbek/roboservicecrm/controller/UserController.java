package uz.rayimbek.roboservicecrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.rayimbek.roboservicecrm.dto.UserRequestDto;
import uz.rayimbek.roboservicecrm.dto.UserResponseDto;
import uz.rayimbek.roboservicecrm.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto create(@RequestBody UserRequestDto dto) {
        return userService.create(dto);
    }

    @GetMapping("/{id}")
    public UserResponseDto getOne(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.getAll();
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable Long id, @RequestBody UserRequestDto dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}