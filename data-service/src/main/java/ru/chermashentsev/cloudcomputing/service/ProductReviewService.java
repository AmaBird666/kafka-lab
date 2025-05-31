package ru.voroncov.cloudcomputing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.voroncov.cloudcomputing.entity.Product;
import ru.voroncov.cloudcomputing.entity.ProductReview;
import ru.voroncov.cloudcomputing.exception.ProductNotFoundException;
import ru.voroncov.cloudcomputing.exception.UserNotFoundException;
import ru.voroncov.cloudcomputing.repository.ProductRepository;
import ru.voroncov.cloudcomputing.repository.ProductReviewRepository;
import ru.voroncov.cloudcomputing.repository.UserRepository;

import java.util.List;

import static ru.voroncov.cloudcomputing.constants.ErrorCode.PRODUCT_NOT_FOUND;
import static ru.voroncov.cloudcomputing.constants.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProductReviewService {

    private final ProductReviewRepository productReviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;


    public List<ProductReview> getAll() {
        return productReviewRepository.findAll();
    }

    public ProductReview save(ProductReview productReview) {
        long productId = productReview.getProduct().getId();
        long userId = productReview.getUser().getId();

        findProductById(productId);

        userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND.format(userId)));

        return productReviewRepository.save(productReview);
    }


    private Product findProductById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(PRODUCT_NOT_FOUND.format(id)));
    }

}
