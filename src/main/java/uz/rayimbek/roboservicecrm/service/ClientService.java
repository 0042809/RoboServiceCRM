package uz.rayimbek.roboservicecrm.service;

import uz.rayimbek.roboservicecrm.dto.ClientRequestDto;
import uz.rayimbek.roboservicecrm.dto.ClientResponseDto;

import java.util.List;

public interface ClientService {
    ClientResponseDto create(ClientRequestDto dto);
    ClientResponseDto update(Long id, ClientRequestDto dto);
    ClientResponseDto getOne(Long id);
    List<ClientResponseDto> getAll();
    void delete(Long id);
}
