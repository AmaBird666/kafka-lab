package ru.voroncov.cloudcomputing.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.voroncov.cloudcomputing.dto.request.product.CreateProductRequestDTO;
import ru.voroncov.cloudcomputing.dto.request.user.CreateUserRequestDTO;
import ru.voroncov.cloudcomputing.entity.Product;
import ru.voroncov.cloudcomputing.entity.User;
import ru.voroncov.cloudcomputing.mapper.UserMapper;
import ru.voroncov.cloudcomputing.service.UserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserConsumer {


    private final UserMapper userMapper;
    private final UserService userService;

    @KafkaListener(topics = "${app.kafka.user-topic}")
    public void listen(ConsumerRecord<String, CreateUserRequestDTO> record) {
        CreateUserRequestDTO requestDTO = record.value();
        User user = userMapper.toModel(requestDTO);

        userService.save(user);
        log.info("User created: {}", user);
    }

}
