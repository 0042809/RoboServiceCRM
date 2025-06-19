package uz.rayimbek.roboservicecrm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.rayimbek.roboservicecrm.dto.CompanyRequestDto;
import uz.rayimbek.roboservicecrm.dto.CompanyResponseDto;
import uz.rayimbek.roboservicecrm.service.CompanyService;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
@Tag(name = "Company", description = "Kompaniya CRUD")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    @Operation(summary = "Barcha kompaniyalarni olish")
    public List<CompanyResponseDto> getAll() {
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "ID orqali kompaniya olish")
    public CompanyResponseDto getById(@PathVariable Long id) {
        return companyService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Yangi kompaniya yaratish")
    public CompanyResponseDto create(@RequestBody @Valid CompanyRequestDto dto) {
        return companyService.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Kompaniyani yangilash")
    public CompanyResponseDto update(@PathVariable Long id, @RequestBody @Valid CompanyRequestDto dto) {
        return companyService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Kompaniyani o‘chirish")
    public void delete(@PathVariable Long id) {
        companyService.delete(id);
    }
}