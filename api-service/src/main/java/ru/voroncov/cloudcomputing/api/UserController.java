package ru.voroncov.cloudcomputing.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.voroncov.cloudcomputing.client.ApiClient;
import ru.voroncov.cloudcomputing.dto.request.user.CreateUserRequestDTO;
import ru.voroncov.cloudcomputing.dto.response.user.UserResponseDTO;
import ru.voroncov.cloudcomputing.kafka.KafkaProducer;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final KafkaProducer kafkaProducer;
    private final ApiClient apiClient;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody CreateUserRequestDTO requestDTO) {
        kafkaProducer.sendUser(requestDTO);
        return ResponseEntity.ok("Successfully added user");
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return ResponseEntity.ok(apiClient.getAllUsers().getBody());
    }
}
