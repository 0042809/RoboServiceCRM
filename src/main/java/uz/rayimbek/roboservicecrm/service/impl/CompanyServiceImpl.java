package uz.rayimbek.roboservicecrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.rayimbek.roboservicecrm.dto.CompanyRequestDto;
import uz.rayimbek.roboservicecrm.dto.CompanyResponseDto;
import uz.rayimbek.roboservicecrm.entity.Company;
import uz.rayimbek.roboservicecrm.repository.CompanyRepository;
import uz.rayimbek.roboservicecrm.service.CompanyService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Override
    public List<CompanyResponseDto> findAll() {
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyResponseDto findById(Long id) {
        Company company = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        return toDto(company);
    }

    @Override
    public CompanyResponseDto save(CompanyRequestDto dto) {
        Company company = fromDto(dto);
        return toDto(repository.save(company));
    }

    @Override
    public CompanyResponseDto update(Long id, CompanyRequestDto dto) {
        Company company = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        company.setName(dto.getName());
        company.setAddress(dto.getAddress());
        company.setDescription(dto.getDescription());
        company.setActive(dto.isActive());
        return toDto(repository.save(company));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CompanyResponseDto toDto(Company company) {
        return CompanyResponseDto.builder()
                .id(company.getId())
                .name(company.getName())
                .address(company.getAddress())
                .description(company.getDescription())
                .active(company.isActive())
                .build();
    }

    private Company fromDto(CompanyRequestDto dto) {
        return Company.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .description(dto.getDescription())
                .active(dto.isActive())
                .build();
    }
}
