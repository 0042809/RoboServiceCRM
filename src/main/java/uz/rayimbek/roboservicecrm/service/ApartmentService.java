package uz.rayimbek.roboservicecrm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.rayimbek.roboservicecrm.dto.ApartmentRequestDto;
import uz.rayimbek.roboservicecrm.dto.ApartmentResponseDto;
import uz.rayimbek.roboservicecrm.entity.Apartment;
import uz.rayimbek.roboservicecrm.entity.Block;
import uz.rayimbek.roboservicecrm.entity.Floor;
import uz.rayimbek.roboservicecrm.repository.ApartmentRepository;
import uz.rayimbek.roboservicecrm.repository.BlockRepository;
import uz.rayimbek.roboservicecrm.repository.FloorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private final BlockRepository blockRepository;
    private final FloorRepository floorRepository;

    public ApartmentResponseDto create(ApartmentRequestDto dto) {
        Block block = blockRepository.findById(dto.getBlockId())
                .orElseThrow(() -> new RuntimeException("Block not found"));

        Floor floor = floorRepository.findById(dto.getFloorId())
                .orElseThrow(() -> new RuntimeException("Floor not found"));

        Apartment apartment = Apartment.builder()
                .apartmentName(dto.getApartmentName())
                .price(dto.getPrice())
                .roomCount(dto.getRoomCount())
                .sqrM(dto.getSqrM())
                .block(block)
                .floor(floor)
                .status(dto.getStatus())
                .build();

        apartment = apartmentRepository.save(apartment);
        return toResponseDto(apartment);
    }

    public List<ApartmentResponseDto> getAll() {
        return apartmentRepository.findAll().stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public ApartmentResponseDto getById(Long id) {
        return toResponseDto(apartmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appartment not found")));
    }

    public void delete(Long id) {
        apartmentRepository.deleteById(id);
    }

    public ApartmentResponseDto update(Long id, ApartmentRequestDto dto) {
        Apartment apartment = apartmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appartment not found"));

        Block block = blockRepository.findById(dto.getBlockId())
                .orElseThrow(() -> new RuntimeException("Block not found"));

        Floor floor = floorRepository.findById(dto.getFloorId())
                .orElseThrow(() -> new RuntimeException("Floor not found"));

        apartment.setApartmentName(dto.getApartmentName());
        apartment.setPrice(dto.getPrice());
        apartment.setRoomCount(dto.getRoomCount());
        apartment.setSqrM(dto.getSqrM());
        apartment.setBlock(block);
        apartment.setFloor(floor);
        apartment.setStatus(dto.getStatus());

        return toResponseDto(apartmentRepository.save(apartment));
    }

    private ApartmentResponseDto toResponseDto(Apartment apartment) {
        return ApartmentResponseDto.builder()
                .id(apartment.getId())
                .apartmentName(apartment.getApartmentName())
                .price(apartment.getPrice())
                .roomCount(apartment.getRoomCount())
                .sqrM(apartment.getSqrM())
                .blockId(apartment.getBlock().getId())
                .floorId(apartment.getFloor().getId())
                .status(apartment.getStatus())
                .build();
    }
}
