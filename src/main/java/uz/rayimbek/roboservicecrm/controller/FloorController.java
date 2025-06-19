package uz.rayimbek.roboservicecrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.rayimbek.roboservicecrm.dto.FloorRequestDto;
import uz.rayimbek.roboservicecrm.dto.FloorResponseDto;
import uz.rayimbek.roboservicecrm.service.FloorService;

import java.util.List;

@RestController
@RequestMapping("/api/floors")
@RequiredArgsConstructor
public class FloorController {

    private final FloorService floorService;

    @PostMapping
    public FloorResponseDto create(@RequestBody FloorRequestDto dto) {
        return floorService.create(dto);
    }

    @GetMapping
    public List<FloorResponseDto> getAll() {
        return floorService.getAll();
    }

    @GetMapping("/{id}")
    public FloorResponseDto getOne(@PathVariable Long id) {
        return floorService.getOne(id);
    }

    @PutMapping("/{id}")
    public FloorResponseDto update(@PathVariable Long id, @RequestBody FloorRequestDto dto) {
        return floorService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        floorService.delete(id);
    }
}
