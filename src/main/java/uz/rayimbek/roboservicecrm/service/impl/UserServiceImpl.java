package uz.rayimbek.roboservicecrm.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.rayimbek.roboservicecrm.dto.UserRequestDto;
import uz.rayimbek.roboservicecrm.dto.UserResponseDto;
import uz.rayimbek.roboservicecrm.entity.Company;
import uz.rayimbek.roboservicecrm.entity.Image;
import uz.rayimbek.roboservicecrm.entity.User;
import uz.rayimbek.roboservicecrm.repository.CompanyRepository;
import uz.rayimbek.roboservicecrm.repository.ImageRepository;
import uz.rayimbek.roboservicecrm.repository.UserRepository;
import uz.rayimbek.roboservicecrm.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final ImageRepository imageRepository;

    @Override
    public UserResponseDto create(UserRequestDto dto) {
        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new EntityNotFoundException("Company not found"));
        Image image = imageRepository.findById(dto.getImageId())
                .orElse(null);

        User user = User.builder()
                .userName(dto.getUserName())
                .phoneNumber(dto.getPhoneNumber())
                .birthDate(dto.getBirthDate())
                .passportSerial(dto.getPassportSerial())
                .passportNumber(dto.getPassportNumber())
                .fullName(dto.getFullName())
                .company(company)
                .role(dto.getRole())
                .image(image)
                .password(dto.getPassword())
                .build();

        return toDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto getById(Long id) {
        return toDto(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found")));
    }

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new EntityNotFoundException("Company not found"));
        Image image = imageRepository.findById(dto.getImageId())
                .orElse(null);

        user.setUserName(dto.getUserName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setBirthDate(dto.getBirthDate());
        user.setPassportSerial(dto.getPassportSerial());
        user.setPassportNumber(dto.getPassportNumber());
        user.setFullName(dto.getFullName());
        user.setCompany(company);
        user.setRole(dto.getRole());
        user.setImage(image);
        user.setPassword(dto.getPassword());

        return toDto(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .phoneNumber(user.getPhoneNumber())
                .birthDate(user.getBirthDate())
                .passportSerial(user.getPassportSerial())
                .passportNumber(user.getPassportNumber())
                .fullName(user.getFullName())
                .companyId(user.getCompany().getId())
                .role(user.getRole())
                .imageId(user.getImage() != null ? user.getImage().getId() : null)
                .build();
    }
}
