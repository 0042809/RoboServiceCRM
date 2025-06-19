package uz.rayimbek.roboservicecrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.rayimbek.roboservicecrm.dto.ApartmentRequestDto;
import uz.rayimbek.roboservicecrm.dto.ApartmentResponseDto;
import uz.rayimbek.roboservicecrm.service.ApartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/apartments")
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentService apartmentService;

    @PostMapping
    public ApartmentResponseDto create(@RequestBody ApartmentRequestDto dto) {
        return apartmentService.create(dto);
    }

    @GetMapping
    public List<ApartmentResponseDto> getAll() {
        return apartmentService.getAll();
    }

    @GetMapping("/{id}")
    public ApartmentResponseDto getById(@PathVariable Long id) {
        return apartmentService.getById(id);
    }

    @PutMapping("/{id}")
    public ApartmentResponseDto update(@PathVariable Long id, @RequestBody ApartmentRequestDto dto) {
        return apartmentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        apartmentService.delete(id);
    }
}
