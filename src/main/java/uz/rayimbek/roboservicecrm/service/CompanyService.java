package uz.rayimbek.roboservicecrm.service;

import uz.rayimbek.roboservicecrm.dto.CompanyRequestDto;
import uz.rayimbek.roboservicecrm.dto.CompanyResponseDto;

import java.util.List;

public interface CompanyService {
    List<CompanyResponseDto> findAll();
    CompanyResponseDto findById(Long id);
    CompanyResponseDto save(CompanyRequestDto dto);
    CompanyResponseDto update(Long id, CompanyRequestDto dto);
    void delete(Long id);
}

