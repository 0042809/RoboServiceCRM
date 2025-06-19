package uz.rayimbek.roboservicecrm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.rayimbek.roboservicecrm.dto.FloorRequestDto;
import uz.rayimbek.roboservicecrm.dto.FloorResponseDto;
import uz.rayimbek.roboservicecrm.entity.Block;
import uz.rayimbek.roboservicecrm.entity.Floor;
import uz.rayimbek.roboservicecrm.repository.BlockRepository;
import uz.rayimbek.roboservicecrm.repository.FloorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FloorService {

    private final FloorRepository floorRepository;
    private final BlockRepository blockRepository;

    public FloorResponseDto create(FloorRequestDto dto) {
        Block block = blockRepository.findById(dto.getBlockId())
                .orElseThrow(() -> new RuntimeException("Block not found"));

        Floor floor = Floor.builder()
                .floorName(dto.getFloorName())
                .totalAppartmentsOfFloor(dto.getTotalApartmentsOfFloor())
                .block(block)
                .build();

        floor = floorRepository.save(floor);
        return toDto(floor);
    }

    public List<FloorResponseDto> getAll() {
        return floorRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public FloorResponseDto getOne(Long id) {
        return toDto(floorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Floor not found")));
    }

    public FloorResponseDto update(Long id, FloorRequestDto dto) {
        Floor floor = floorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Floor not found"));

        Block block = blockRepository.findById(dto.getBlockId())
                .orElseThrow(() -> new RuntimeException("Block not found"));

        floor.setFloorName(dto.getFloorName());
        floor.setTotalAppartmentsOfFloor(dto.getTotalApartmentsOfFloor());
        floor.setBlock(block);

        return toDto(floorRepository.save(floor));
    }

    public void delete(Long id) {
        floorRepository.deleteById(id);
    }

    private FloorResponseDto toDto(Floor floor) {
        return FloorResponseDto.builder()
                .id(floor.getId())
                .floorName(floor.getFloorName())
                .totalApartmentsOfFloor(floor.getTotalAppartmentsOfFloor())
                .blockId(floor.getBlock().getId())
                .build();
    }
}
