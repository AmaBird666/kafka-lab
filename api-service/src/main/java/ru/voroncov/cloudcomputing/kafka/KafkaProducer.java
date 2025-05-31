package ru.voroncov.cloudcomputing.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.voroncov.cloudcomputing.config.AppConfig;
import ru.voroncov.cloudcomputing.dto.request.product.CreateProductRequestDTO;
import ru.voroncov.cloudcomputing.dto.request.product.review.CreateProductReviewRequestDTO;
import ru.voroncov.cloudcomputing.dto.request.user.CreateUserRequestDTO;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private final AppConfig appConfig;


    public void sendProduct(CreateProductRequestDTO requestDTO) {
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send(appConfig.getProductTopic(), key, requestDTO);
    }

    public void sendUser(CreateUserRequestDTO requestDTO) {
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send(appConfig.getUserTopic(), key, requestDTO);
    }

    public void sendReview(CreateProductReviewRequestDTO requestDTO) {
        String key = requestDTO.getProductId().toString();
        kafkaTemplate.send(appConfig.getReviewTopic(), key, requestDTO);
    }

}
