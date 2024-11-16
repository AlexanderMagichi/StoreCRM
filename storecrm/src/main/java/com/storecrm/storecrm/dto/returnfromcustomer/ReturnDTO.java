package com.storecrm.storecrm.dto.returnfromcustomer;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReturnDTO {
    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private String reason;
    private LocalDateTime returnDate;
    private Long purchaseInvoiceId;
}
