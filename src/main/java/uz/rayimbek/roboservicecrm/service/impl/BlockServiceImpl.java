package uz.rayimbek.roboservicecrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.rayimbek.roboservicecrm.dto.BlockRequestDto;
import uz.rayimbek.roboservicecrm.dto.BlockResponseDto;
import uz.rayimbek.roboservicecrm.entity.Block;
import uz.rayimbek.roboservicecrm.repository.BlockRepository;
import uz.rayimbek.roboservicecrm.repository.CompanyRepository;
import uz.rayimbek.roboservicecrm.service.BlockService;
import uz.rayimbek.roboservicecrm.entity.Company;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlockServiceImpl implements BlockService {

    private final BlockRepository blockRepository;
    private final CompanyRepository companyRepository;

    @Override
    public BlockResponseDto create(BlockRequestDto dto) {
        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Block block = Block.builder()
                .blockName(dto.getBlockName())
                .totalApartments(dto.getTotalApartments())
                .totalFloors(dto.getTotalFloors())
                .company(company)
                .build();

        block = blockRepository.save(block);
        return toResponse(block);
    }

    @Override
    public BlockResponseDto update(Long id, BlockRequestDto dto) {
        Block block = blockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Block not found"));

        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        block.setBlockName(dto.getBlockName());
        block.setTotalApartments(dto.getTotalApartments());
        block.setTotalFloors(dto.getTotalFloors());
        block.setCompany(company);

        return toResponse(blockRepository.save(block));
    }

    @Override
    public BlockResponseDto get(Long id) {
        return toResponse(blockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Block not found")));
    }

    @Override
    public List<BlockResponseDto> getAll() {
        return blockRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        blockRepository.deleteById(id);
    }

    private BlockResponseDto toResponse(Block block) {
        return BlockResponseDto.builder()
                .id(block.getId())
                .blockName(block.getBlockName())
                .totalApartments(block.getTotalApartments())
                .totalFloors(block.getTotalFloors())
                .companyId(block.getCompany().getId())
                .build();
    }
}
