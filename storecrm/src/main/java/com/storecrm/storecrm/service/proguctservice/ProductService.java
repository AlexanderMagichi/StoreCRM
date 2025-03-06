package com.storecrm.storecrm.service.proguctservice;

import com.storecrm.storecrm.dto.productdto.ProductDTO;

import java.util.List;

/**
 * Interface for managing products.
 * Defines methods for retrieving, creating, and deleting productdto data.
 */
public interface ProductService {

    /**
     * Retrieves all products from the database.
     *
     * @return a list of ProductResponse DTOs representing all products.
     */
    List<ProductDTO.ProductResponse> getAllProducts();

    /**
     * Retrieves a productdto by its ID.
     *
     * @param id the ID of the productdto to retrieve.
     * @return a ProductResponse DTO representing the retrieved productdto.
     */
    ProductDTO.ProductResponse getProductById(Long id);

    /**
     * Creates a new productdto and saves it to the database.
     *
     * @param productDTO the data for the productdto to create.
     * @return a ProductResponse DTO representing the created productdto.
     */
    ProductDTO.ProductResponse createProduct(ProductDTO.Create productDTO);

    /**
     * Deletes a productdto by its ID.
     *
     * @param id the ID of the productdto to delete.
     */
    void deleteProduct(Long id);
}
