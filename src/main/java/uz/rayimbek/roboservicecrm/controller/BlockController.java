package uz.rayimbek.roboservicecrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.rayimbek.roboservicecrm.dto.BlockRequestDto;
import uz.rayimbek.roboservicecrm.dto.BlockResponseDto;
import uz.rayimbek.roboservicecrm.service.BlockService;

import java.util.List;

@RestController
@RequestMapping("/api/blocks")
@RequiredArgsConstructor
public class BlockController {

    private final BlockService blockService;

    @PostMapping
    public BlockResponseDto create(@RequestBody BlockRequestDto dto) {
        return blockService.create(dto);
    }

    @PutMapping("/{id}")
    public BlockResponseDto update(@PathVariable Long id, @RequestBody BlockRequestDto dto) {
        return blockService.update(id, dto);
    }

    @GetMapping("/{id}")
    public BlockResponseDto getOne(@PathVariable Long id) {
        return blockService.get(id);
    }

    @GetMapping
    public List<BlockResponseDto> getAll() {
        return blockService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        blockService.delete(id);
    }
}
