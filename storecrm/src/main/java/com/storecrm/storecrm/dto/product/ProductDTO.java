package com.storecrm.storecrm.dto.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime lastUpdated;
    private Long supplierId;
    private String supplierName;


}
