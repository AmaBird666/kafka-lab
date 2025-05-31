package ru.voroncov.cloudcomputing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.voroncov.cloudcomputing.entity.Product;
import ru.voroncov.cloudcomputing.exception.ProductNotFoundException;
import ru.voroncov.cloudcomputing.repository.ProductRepository;

import java.util.List;

import static ru.voroncov.cloudcomputing.constants.ErrorCode.PRODUCT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(PRODUCT_NOT_FOUND.format(id)));
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public Product delete(long id) {
        Product savedProduct = findById(id);
        productRepository.delete(savedProduct);

        return savedProduct;
    }

}
