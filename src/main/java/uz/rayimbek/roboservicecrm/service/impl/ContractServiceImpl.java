package uz.rayimbek.roboservicecrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.rayimbek.roboservicecrm.dto.ContractRequestDto;
import uz.rayimbek.roboservicecrm.dto.ContractResponseDto;
import uz.rayimbek.roboservicecrm.entity.*;
import uz.rayimbek.roboservicecrm.repository.*;
import uz.rayimbek.roboservicecrm.service.ContractService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final ApartmentRepository apartmentRepository;
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    @Override
    public ContractResponseDto create(ContractRequestDto dto) {
        Contract contract = Contract.builder()
                .contractId(dto.getContractId())
                .apartment(apartmentRepository.findById(dto.getApartmentId()).orElseThrow())
                .client(clientRepository.findById(dto.getClientId()).orElseThrow())
                .user(userRepository.findById(dto.getUserId()).orElseThrow())
                .company(companyRepository.findById(dto.getCompanyId()).orElseThrow())
                .contractDate(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return toDto(contractRepository.save(contract));
    }

    @Override
    public ContractResponseDto getOne(Long id) {
        return toDto(contractRepository.findById(id).orElseThrow());
    }

    @Override
    public List<ContractResponseDto> getAll() {
        return contractRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ContractResponseDto update(Long id, ContractRequestDto dto) {
        Contract contract = contractRepository.findById(id).orElseThrow();
        contract.setContractId(dto.getContractId());
        contract.setApartment(apartmentRepository.findById(dto.getApartmentId()).orElseThrow());
        contract.setClient(clientRepository.findById(dto.getClientId()).orElseThrow());
        contract.setUser(userRepository.findById(dto.getUserId()).orElseThrow());
        contract.setCompany(companyRepository.findById(dto.getCompanyId()).orElseThrow());
        contract.setUpdatedAt(LocalDateTime.now());
        return toDto(contractRepository.save(contract));
    }

    @Override
    public void delete(Long id) {
        contractRepository.deleteById(id);
    }

    private ContractResponseDto toDto(Contract contract) {
        return ContractResponseDto.builder()
                .id(contract.getId())
                .contractId(contract.getContractId())
                .apartmentId(contract.getApartment().getId())
                .clientId(contract.getClient().getId())
                .userId(contract.getUser().getId())
                .companyId(contract.getCompany().getId())
                .contractDate(contract.getContractDate())
                .createdAt(contract.getCreatedAt())
                .updatedAt(contract.getUpdatedAt())
                .build();
    }
}
