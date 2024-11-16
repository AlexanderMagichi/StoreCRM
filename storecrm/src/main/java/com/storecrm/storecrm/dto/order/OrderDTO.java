package com.storecrm.storecrm.dto.order;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private LocalDateTime date;
    private Long customerId;
    private String status;
    private BigDecimal totalAmount;
}
