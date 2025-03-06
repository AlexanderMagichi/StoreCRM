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
 * Implementation of ProductService.
 * Provides methods for managing products.
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCT_NOT_FOUND = "Product not found with id: ";

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO.ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDTO)
                .toList();
    }

    @Override
    public ProductDTO.ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(PRODUCT_NOT_FOUND + id));
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO.ProductResponse createProduct(ProductDTO.Create productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException(PRODUCT_NOT_FOUND + id);
        }
        productRepository.deleteById(id);
    }
}
