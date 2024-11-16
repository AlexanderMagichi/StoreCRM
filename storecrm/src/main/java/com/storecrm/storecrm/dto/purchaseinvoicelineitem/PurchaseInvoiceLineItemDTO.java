package com.storecrm.storecrm.dto.purchaseinvoicelineitem;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PurchaseInvoiceLineItemDTO {
    private Long id;
    private Long invoiceId;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}
