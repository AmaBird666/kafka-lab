package ru.voroncov.cloudcomputing.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.voroncov.cloudcomputing.dto.request.product.review.CreateProductReviewRequestDTO;
import ru.voroncov.cloudcomputing.dto.response.product.ProductResponseDTO;
import ru.voroncov.cloudcomputing.dto.response.product.review.ProductReviewResponseDTO;
import ru.voroncov.cloudcomputing.entity.Product;
import ru.voroncov.cloudcomputing.entity.ProductReview;
import ru.voroncov.cloudcomputing.mapper.ProductReviewMapper;
import ru.voroncov.cloudcomputing.service.ProductReviewService;
import ru.voroncov.cloudcomputing.service.ProductService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("reviews")
@RequiredArgsConstructor
public class ProductReviewController {

    private final ProductReviewService productReviewService;
    private final ProductReviewMapper productReviewMapper;
    private final ProductService productService;


    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductReviewResponseDTO>> getAllProductReviews() {
        List<ProductReviewResponseDTO> productResponseDTOList = productReviewService.getAll()
                .stream()
                .map(productReviewMapper::toDto)
                .toList();

        return ResponseEntity.ok(productResponseDTOList);
    }


    @PostMapping(value = "/{ID}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductReviewResponseDTO> createProductReview(
            @Valid @RequestBody CreateProductReviewRequestDTO productReviewRequestDTO,
            @PathVariable("ID") long id
    ) {

        ProductReview productReview = productReviewMapper.toModel(productReviewRequestDTO);

        Product product = productService.findById(id);
        productReview.setProduct(product);

        productReview = productReviewService.save(productReview);

        ProductReviewResponseDTO productReviewResponseDTO = productReviewMapper.toDto(productReview);

        return ResponseEntity.ok(productReviewResponseDTO);
    }

}
