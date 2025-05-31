package ru.voroncov.cloudcomputing.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import ru.voroncov.cloudcomputing.dto.request.product.CreateProductRequestDTO;
import ru.voroncov.cloudcomputing.dto.request.product.UpdateProductRequestDTO;
import ru.voroncov.cloudcomputing.dto.response.product.ProductResponseDTO;
import ru.voroncov.cloudcomputing.entity.Product;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    Product toModel(CreateProductRequestDTO productDTO);

    ProductResponseDTO toDto(Product product);

    void updateProductFromDto(UpdateProductRequestDTO productDTO, @MappingTarget Product product);

}
