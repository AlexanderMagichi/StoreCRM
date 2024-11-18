package com.storecrm.storecrm.mapper.purchaseinvoicelineitem;

import com.storecrm.storecrm.dto.purchaseinvoicelineitem.PurchaseInvoiceLineItemDTO;
import com.storecrm.storecrm.model.purchaseinvoice.PurchaseInvoice;
import com.storecrm.storecrm.model.purchaseinvoicelineitem.PurchaseInvoiceLineItem;
import com.storecrm.storecrm.model.product.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PurchaseInvoiceLineItemMapper {

    /**
     * Converts {@link PurchaseInvoiceLineItem} entity to DTO.
     *
     * @param lineItem entity to convert
     * @return corresponding DTO
     */
    public PurchaseInvoiceLineItemDTO toDTO(PurchaseInvoiceLineItem lineItem) {
        if (lineItem == null) {
            throw new IllegalArgumentException("PurchaseInvoiceLineItem cannot be null");
        }

        return new PurchaseInvoiceLineItemDTO(
                lineItem.getId(),
                lineItem.getInvoice() != null ? lineItem.getInvoice().getId() : null, // Get invoice ID
                lineItem.getProduct() != null ? lineItem.getProduct().getId() : null, // Get product ID
                lineItem.getQuantity(),
                lineItem.getUnitPrice() != null ? BigDecimal.valueOf(lineItem.getUnitPrice()) : null, // Convert unitPrice to BigDecimal
                lineItem.getTotalAmount() != null ? BigDecimal.valueOf(lineItem.getTotalAmount()) : null // Convert totalAmount to BigDecimal
        );
    }

    /**
     * Converts {@link PurchaseInvoiceLineItemDTO} to entity.
     *
     * @param lineItemDTO DTO to convert
     * @return corresponding entity
     */
    public PurchaseInvoiceLineItem toEntity(PurchaseInvoiceLineItemDTO lineItemDTO) {
        if (lineItemDTO == null) {
            throw new IllegalArgumentException("PurchaseInvoiceLineItemDTO cannot be null");
        }

        PurchaseInvoiceLineItem lineItem = PurchaseInvoiceLineItem.builder()
                .id(lineItemDTO.getId())
                .quantity(lineItemDTO.getQuantity())
                .unitPrice(lineItemDTO.getPrice().doubleValue()) // Convert BigDecimal to Double
                .build();

        if (lineItemDTO.getInvoiceId() != null) {
            PurchaseInvoice invoice = new PurchaseInvoice();
            invoice.setId(lineItemDTO.getInvoiceId());
            lineItem.setInvoice(invoice);
        }

        if (lineItemDTO.getProductId() != null) {
            Product product = new Product();
            product.setId(lineItemDTO.getProductId());
            lineItem.setProduct(product);
        }

        return lineItem;
    }
}
