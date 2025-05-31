package ru.voroncov.cloudcomputing.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.voroncov.cloudcomputing.client.ApiClient;
import ru.voroncov.cloudcomputing.dto.request.product.CreateProductRequestDTO;
import ru.voroncov.cloudcomputing.dto.response.product.ProductResponseDTO;
import ru.voroncov.cloudcomputing.kafka.KafkaProducer;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final KafkaProducer kafkaProducer;
    private final ApiClient apiClient;


    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody CreateProductRequestDTO requestDTO) {
        kafkaProducer.sendProduct(requestDTO);
        return ResponseEntity.ok("Successfully added product");
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        return ResponseEntity.ok(apiClient.getAllProducts().getBody());
    }


}
