package com.storecrm.storecrm.dto.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Art cannot be blank")
    @Size(max = 50, message = "Art cannot exceed 50 characters")
    private String art;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "Stock cannot be null")
    @Min(value = 0, message = "Stock must be at least 0")
    private Integer stock;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime lastUpdated;

    @NotNull(message = "Supplier ID cannot be null")
    private Long supplierId;

    @Size(max = 100, message = "Supplier name cannot exceed 100 characters")
    private String supplierName;

    @Data
    @NoArgsConstructor
    @Builder
    public static class ProductResponse {
        private Long id;
        private String name;
        private BigDecimal price;

        public ProductResponse(Long id, String name, BigDecimal price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    @Data
    @NoArgsConstructor
    @Builder
    public static class Create {
        private String name;
        private BigDecimal price;

        public Create(String name, BigDecimal price) {
            this.name = name;
            this.price = price;
        }
    }
}
