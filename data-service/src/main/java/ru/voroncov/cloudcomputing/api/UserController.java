package ru.voroncov.cloudcomputing.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.voroncov.cloudcomputing.dto.request.user.CreateUserRequestDTO;
import ru.voroncov.cloudcomputing.dto.response.user.UserResponseDTO;
import ru.voroncov.cloudcomputing.entity.User;
import ru.voroncov.cloudcomputing.mapper.UserMapper;
import ru.voroncov.cloudcomputing.service.UserService;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> userResponseDTOList = userService.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();

        return ResponseEntity.ok(userResponseDTOList);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody CreateUserRequestDTO userRequestDTO) {
        User user = userMapper.toModel(userRequestDTO);

        User savedUser = userService.save(user);

        UserResponseDTO userResponseDTO = userMapper.toDto(savedUser);

        return ResponseEntity.ok(userResponseDTO);
    }

    @DeleteMapping(value = "{ID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable("ID") long id) {
        User user = userService.delete(id);

        UserResponseDTO userResponseDTO = userMapper.toDto(user);

        return ResponseEntity.ok(userResponseDTO);
    }

}
