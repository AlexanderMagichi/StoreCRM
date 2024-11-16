package com.storecrm.storecrm.dto.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String art;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private LocalDateTime lastUpdated;
    private long supplierId;

}
