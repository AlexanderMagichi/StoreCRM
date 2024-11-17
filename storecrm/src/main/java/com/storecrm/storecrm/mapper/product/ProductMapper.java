package com.storecrm.storecrm.mapper.product;

import com.storecrm.storecrm.dto.product.ProductDTO;
import com.storecrm.storecrm.model.product.Product;
import org.springframework.stereotype.Component;

import java.util.Optional;



/**
 * Mapper for converting Product entity to ProductDTO and vice versa.
 */
@Component
public class ProductMapper {

    /**
     * Converts a Product entity to an Optional<ProductDTO.Public>.
     *
     * @param product the Product entity.
     * @return Optional containing the public DTO of the product, or Optional.empty if product is null.
     */
    public Optional<ProductDTO.ProductResponse> toDTO(Product product) {
        return Optional.ofNullable(product)
                .map(p -> ProductDTO.ProductResponse.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .price(p.getPrice())
                        .build());
    }

    /**
     * Converts an Optional<ProductDTO.Create> to a Product entity.
     *
     * @param productDTO Optional containing the DTO for product creation.
     * @return Optional containing the Product entity, or Optional.empty if productDTO is empty.
     */
    public Optional<Product> toEntity(Optional<ProductDTO.Create> productDTO) {
        return productDTO.map(dto -> Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .build());
    }
}
