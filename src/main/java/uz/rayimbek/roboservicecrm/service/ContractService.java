package uz.rayimbek.roboservicecrm.service;

import uz.rayimbek.roboservicecrm.dto.ContractRequestDto;
import uz.rayimbek.roboservicecrm.dto.ContractResponseDto;

import java.util.List;

public interface ContractService {
    ContractResponseDto create(ContractRequestDto dto);
    ContractResponseDto getOne(Long id);
    List<ContractResponseDto> getAll();
    ContractResponseDto update(Long id, ContractRequestDto dto);
    void delete(Long id);
}
