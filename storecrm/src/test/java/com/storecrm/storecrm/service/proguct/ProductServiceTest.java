package com.storecrm.storecrm.service.proguct;

import com.storecrm.storecrm.dto.product.ProductDTO;
import com.storecrm.storecrm.mapper.product.ProductMapper;
import com.storecrm.storecrm.model.product.Product;
import com.storecrm.storecrm.repository.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    @Test
    void getProductById_shouldReturnProductResponse_whenProductExists() {
        // Arrange
        Long productID = 1L;

        Product mockProduct = new Product();
        mockProduct.setId(productID);
        mockProduct.setName("Test Product");

        ProductDTO.ProductResponse mockResponse = new ProductDTO.ProductResponse();
        mockResponse.setId(productID);
        mockResponse.setName("Test Product");

        when(productRepository.findById(productID)).thenReturn(Optional.of(mockProduct));
        when(productMapper.toDTO(mockProduct)).thenReturn(mockResponse);

        // Act
        ProductDTO.ProductResponse actualResponse = productService.getProductById(productID);

        // Assert
        assertNotNull(actualResponse, "Response should not be null");
        assertEquals(mockResponse, actualResponse, "Response should match the expected DTO");

        verify(productRepository).findById(productID);
        verify(productMapper).toDTO(mockProduct);
        verifyNoMoreInteractions(productRepository, productMapper);
    }

    @Test
    void getProductById_shouldThrowException_whenProductNotFound() {
        // Arrange
        Long productId = 2L;
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // Act & Assert
        EntityNotFoundException exception = assertThrows(
                EntityNotFoundException.class,
                () -> productService.getProductById(productId),
                "Expected an EntityNotFoundException to be thrown"
        );

        assertEquals("Product not found with id: " + productId, exception.getMessage(), "Error message should match");

        verify(productRepository).findById(productId);
        verifyNoInteractions(productMapper);
    }
}
