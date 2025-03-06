package com.storecrm.storecrm.dto.productdto;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "Represents a productdto in the system.")
public class ProductDTO {

    @Schema(description = "The unique identifier for the productdto", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "Art cannot be blank")
    @Size(max = 50, message = "Art cannot exceed 50 characters")
    @Schema(description = "The unique art code of the productdto", example = "ART12345")
    private String art;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @Schema(description = "The name of the productdto", example = "Laptop")
    private String name;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    @Schema(description = "The description of the productdto", example = "A high-performance laptop with 16GB RAM.")
    private String description;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Schema(description = "The price of the productdto", example = "999.99")
    private BigDecimal price;

    @NotNull(message = "Stock cannot be null")
    @Min(value = 0, message = "Stock must be at least 0")
    @Schema(description = "The quantity of the productdto in stock", example = "50")
    private Integer stock;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Schema(description = "The date and time when the productdto was last updated", example = "2024-11-30T12:34:56")
    private LocalDateTime lastUpdated;

    @NotNull(message = "Supplier ID cannot be null")
    @Schema(description = "The ID of the supplierservice of the productdto", example = "1")
    private Long supplierId;

    @Size(max = 100, message = "Supplier name cannot exceed 100 characters")
    @Schema(description = "The name of the supplierservice of the productdto", example = "TechCorp")
    private String supplierName;

    @Data
    @NoArgsConstructor
    @Builder
    @Schema(description = "Response model for a productdto")
    public static class ProductResponse {
        @Schema(description = "The unique identifier for the productdto", example = "1")
        private Long id;

        @Schema(description = "The name of the productdto", example = "Laptop")
        private String name;

        @Schema(description = "The price of the productdto", example = "999.99")
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
    @Schema(description = "Model for creating a new productdto")
    public static class Create {
        @Schema(description = "The name of the productdto", example = "Laptop")
        private String name;

        @Schema(description = "The price of the productdto", example = "999.99")
        private BigDecimal price;

        public Create(String name, BigDecimal price) {
            this.name = name;
            this.price = price;
        }
    }
}
