package ru.voroncov.cloudcomputing.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.voroncov.cloudcomputing.dto.request.product.CreateProductRequestDTO;
import ru.voroncov.cloudcomputing.dto.request.product.review.CreateProductReviewRequestDTO;
import ru.voroncov.cloudcomputing.entity.Product;
import ru.voroncov.cloudcomputing.entity.ProductReview;
import ru.voroncov.cloudcomputing.entity.User;
import ru.voroncov.cloudcomputing.mapper.ProductReviewMapper;
import ru.voroncov.cloudcomputing.service.ProductReviewService;
import ru.voroncov.cloudcomputing.service.ProductService;
import ru.voroncov.cloudcomputing.service.UserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewConsumer {

    private final ProductReviewService productReviewService;
    private final ProductService productService;
    private final ProductReviewMapper productReviewMapper;
    private final UserService userService;

    @KafkaListener(topics = "${app.kafka.review-topic}")
    public void listen(ConsumerRecord<String, CreateProductReviewRequestDTO> record) {
        CreateProductReviewRequestDTO requestDTO = record.value();
        ProductReview productReview = productReviewMapper.toModel(requestDTO);

        Product product = productService.findById(requestDTO.getProductId());
        productReview.setProduct(product);

        User user = userService.findUserById(requestDTO.getUserId());
        productReview.setUser(user);

        productReviewService.save(productReview);
        log.info("Review created: {}", productReview);
    }

}
