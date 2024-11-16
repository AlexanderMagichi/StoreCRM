package com.storecrm.storecrm.dto.returninvoice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReturnInvoiceDTO {
    private Long id;
    private LocalDateTime date;
    private Long supplierId;
    private BigDecimal totalAmount;
    private String status;
    private Long createdBy;
}
