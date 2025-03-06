package com.storecrm.storecrm.mapper.product;

import com.storecrm.storecrm.dto.productdto.ProductDTO;
import com.storecrm.storecrm.model.product.Product;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Mapper for converting Product entity to ProductDTO and vice versa.
 */
@Component
public class ProductMapper {

    /**
     * Converts a Product entity to a ProductDTO.
     *
     * @param product the Product entity.
     * @return ProductDTO.ProductResponse if productdto is not null.
     */
    public ProductDTO.ProductResponse toDTO(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return ProductDTO.ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    /**
     * Converts a ProductDTO.Create to a Product entity.
     *
     * @param productDTO the DTO for productdto creation.
     * @return the Product entity.
     */
    public Product toEntity(ProductDTO.Create productDTO) {
        if (productDTO == null) {
            throw new IllegalArgumentException("ProductDTO cannot be null");
        }
        return Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .build();
    }

    /**
     * Converts an Optional<ProductDTO.Create> to a Product entity.
     *
     * @param productDTO Optional containing the DTO for productdto creation.
     * @return Optional containing the Product entity, or Optional.empty if productDTO is empty.
     */
    public Optional<Product> toEntity(Optional<ProductDTO.Create> productDTO) {
        return productDTO.map(this::toEntity); // Reusing the previous method to avoid duplication
    }
}
