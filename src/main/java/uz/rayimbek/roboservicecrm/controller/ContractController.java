package uz.rayimbek.roboservicecrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.rayimbek.roboservicecrm.dto.ContractRequestDto;
import uz.rayimbek.roboservicecrm.dto.ContractResponseDto;
import uz.rayimbek.roboservicecrm.service.ContractService;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @PostMapping
    public ContractResponseDto create(@RequestBody ContractRequestDto dto) {
        return contractService.create(dto);
    }

    @GetMapping
    public List<ContractResponseDto> getAll() {
        return contractService.getAll();
    }

    @GetMapping("/{id}")
    public ContractResponseDto getOne(@PathVariable Long id) {
        return contractService.getOne(id);
    }

    @PutMapping("/{id}")
    public ContractResponseDto update(@PathVariable Long id, @RequestBody ContractRequestDto dto) {
        return contractService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contractService.delete(id);
    }
}
