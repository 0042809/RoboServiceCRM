package uz.rayimbek.roboservicecrm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.rayimbek.roboservicecrm.entity.Image;
import uz.rayimbek.roboservicecrm.repository.ImageRepository;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageRepository imageRepository;

    private final String uploadDir = "uploads";

    @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        Files.createDirectories(Paths.get(uploadDir));

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir).resolve(fileName);
        Files.write(filePath, file.getBytes());

        Image image = Image.builder()
                .name(fileName)
                .type(file.getContentType())
                .url("/images/" + fileName)
                .build();

        return ResponseEntity.ok(imageRepository.save(image));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable Long id) throws IOException {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));

        Path filePath = Paths.get(uploadDir).resolve(image.getName());
        Resource resource = new UrlResource(filePath.toUri());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, image.getType())
                .body(resource);
    }
}