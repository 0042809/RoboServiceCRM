package uz.rayimbek.roboservicecrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.rayimbek.roboservicecrm.dto.ClientRequestDto;
import uz.rayimbek.roboservicecrm.dto.ClientResponseDto;
import uz.rayimbek.roboservicecrm.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ClientResponseDto create(@RequestBody ClientRequestDto dto) {
        return clientService.create(dto);
    }

    @PutMapping("/{id}")
    public ClientResponseDto update(@PathVariable Long id, @RequestBody ClientRequestDto dto) {
        return clientService.update(id, dto);
    }

    @GetMapping
    public List<ClientResponseDto> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public ClientResponseDto getOne(@PathVariable Long id) {
        return clientService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }
}
