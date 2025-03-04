package com.storecrm.storecrm.service.proguctservice;

import com.storecrm.storecrm.dto.product.ProductDTO;

import java.util.List;

/**
 * Interface for managing products.
 * Defines methods for retrieving, creating, and deleting product data.
 */
public interface ProductService {

    /**
     * Retrieves all products from the database.
     *
     * @return a list of ProductResponse DTOs representing all products.
     */
    List<ProductDTO.ProductResponse> getAllProducts();

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve.
     * @return a ProductResponse DTO representing the retrieved product.
     */
    ProductDTO.ProductResponse getProductById(Long id);

    /**
     * Creates a new product and saves it to the database.
     *
     * @param productDTO the data for the product to create.
     * @return a ProductResponse DTO representing the created product.
     */
    ProductDTO.ProductResponse createProduct(ProductDTO.Create productDTO);

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete.
     */
    void deleteProduct(Long id);
}
