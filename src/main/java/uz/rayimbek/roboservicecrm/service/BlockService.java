package uz.rayimbek.roboservicecrm.service;

import uz.rayimbek.roboservicecrm.dto.BlockRequestDto;
import uz.rayimbek.roboservicecrm.dto.BlockResponseDto;

import java.util.List;

public interface BlockService {
    BlockResponseDto create(BlockRequestDto dto);
    BlockResponseDto update(Long id, BlockRequestDto dto);
    BlockResponseDto get(Long id);
    List<BlockResponseDto> getAll();
    void delete(Long id);
}
