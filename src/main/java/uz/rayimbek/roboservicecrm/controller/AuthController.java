package uz.rayimbek.roboservicecrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.rayimbek.roboservicecrm.dto.AuthRequestDto;
import uz.rayimbek.roboservicecrm.dto.AuthResponseDto;
import uz.rayimbek.roboservicecrm.entity.User;
import uz.rayimbek.roboservicecrm.repository.UserRepository;
import uz.rayimbek.roboservicecrm.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDto dto) {
        User user = userRepository.findByUserName(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(dto.getPassword())) {
            return ResponseEntity.status(401).body("Incorrect password");
        }

        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(new AuthResponseDto(token));
    }
}
