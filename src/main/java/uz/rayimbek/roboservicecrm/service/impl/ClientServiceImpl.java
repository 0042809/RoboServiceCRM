package uz.rayimbek.roboservicecrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.rayimbek.roboservicecrm.dto.ClientRequestDto;
import uz.rayimbek.roboservicecrm.dto.ClientResponseDto;
import uz.rayimbek.roboservicecrm.entity.Apartment;
import uz.rayimbek.roboservicecrm.entity.Client;
import uz.rayimbek.roboservicecrm.entity.Company;
import uz.rayimbek.roboservicecrm.entity.Image;
import uz.rayimbek.roboservicecrm.repository.ApartmentRepository;
import uz.rayimbek.roboservicecrm.repository.ClientRepository;
import uz.rayimbek.roboservicecrm.repository.CompanyRepository;
import uz.rayimbek.roboservicecrm.repository.ImageRepository;
import uz.rayimbek.roboservicecrm.service.ClientService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final CompanyRepository companyRepository;
    private final ImageRepository imageRepository;
    private final ApartmentRepository apartmentRepository;

    @Override
    public ClientResponseDto create(ClientRequestDto dto) {
        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));
        Image image = dto.getImageId() != null
                ? imageRepository.findById(dto.getImageId()).orElse(null)
                : null;
        List<Apartment> apartments = dto.getApartmentIds() != null
                ? apartmentRepository.findAllById(dto.getApartmentIds())
                : List.of();

        Client client = Client.builder()
                .phoneNumber(dto.getPhoneNumber())
                .birthDate(dto.getBirthDate())
                .passportSerial(dto.getPassportSerial())
                .passportNumber(dto.getPassportNumber())
                .fullName(dto.getFullName())
                .company(company)
                .role(dto.getRole())
                .image(image)
                .apartments(apartments)
                .build();

        client = clientRepository.save(client);
        return toDto(client);
    }

    @Override
    public ClientResponseDto update(Long id, ClientRequestDto dto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));
        Image image = dto.getImageId() != null
                ? imageRepository.findById(dto.getImageId()).orElse(null)
                : null;
        List<Apartment> apartments = dto.getApartmentIds() != null
                ? apartmentRepository.findAllById(dto.getApartmentIds())
                : List.of();

        client.setPhoneNumber(dto.getPhoneNumber());
        client.setBirthDate(dto.getBirthDate());
        client.setPassportSerial(dto.getPassportSerial());
        client.setPassportNumber(dto.getPassportNumber());
        client.setFullName(dto.getFullName());
        client.setCompany(company);
        client.setRole(dto.getRole());
        client.setImage(image);
        client.setApartments(apartments);

        client = clientRepository.save(client);
        return toDto(client);
    }

    @Override
    public ClientResponseDto getOne(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return toDto(client);
    }

    @Override
    public List<ClientResponseDto> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private ClientResponseDto toDto(Client client) {
        List<Long> apartmentIds = client.getApartments() != null
                ? client.getApartments().stream()
                .map(Apartment::getId)
                .toList()
                : List.of();

        return ClientResponseDto.builder()
                .id(client.getId())
                .phoneNumber(client.getPhoneNumber())
                .birthDate(client.getBirthDate())
                .passportSerial(client.getPassportSerial())
                .passportNumber(client.getPassportNumber())
                .fullName(client.getFullName())
                .companyId(client.getCompany().getId())
                .role(client.getRole())
                .imageId(client.getImage() != null ? client.getImage().getId() : null)
                .apartmentIds(apartmentIds)
                .build();
    }
}
