package com.storecrm.storecrm.service.proguct;

import com.storecrm.storecrm.dto.product.ProductDTO;
import com.storecrm.storecrm.mapper.product.ProductMapper;
import com.storecrm.storecrm.model.product.Product;
import com.storecrm.storecrm.repository.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing products.
 * Provides methods for retrieving, creating, and deleting product data.
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    /**
     * Constant for the "Product not found" error message.
     */
    private static final String PRODUCT_NOT_FOUND = "Product not found with id: ";

    /**
     * Repository for accessing product data from the database.
     */
    private final ProductRepository productRepository;

    /**
     * Mapper for converting between Product entities and DTOs.
     */
    private final ProductMapper productMapper;

    /**
     * Retrieves all products from the database.
     *
     * @return a list of ProductResponse DTOs representing all products.
     */

    public List<ProductDTO.ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDTO)
                .toList();
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve.
     * @return a ProductResponse DTO representing the retrieved product.
     * @throws EntityNotFoundException if the product with the given ID does not exist.
     */
    public ProductDTO.ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(PRODUCT_NOT_FOUND + id));
        return productMapper.toDTO(product);
    }

    /**
     * Creates a new product and saves it to the database.
     *
     * @param productDTO the data for the product to create.
     * @return a ProductResponse DTO representing the created product.
     */


    public ProductDTO.ProductResponse createProduct(ProductDTO.Create productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete.
     * @throws EntityNotFoundException if the product with the given ID does not exist.
     */

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException(PRODUCT_NOT_FOUND + id);
        }
        productRepository.deleteById(id);
    }
}
