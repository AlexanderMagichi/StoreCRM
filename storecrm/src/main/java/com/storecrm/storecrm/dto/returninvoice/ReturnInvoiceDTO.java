package com.storecrm.storecrm.dto.returninvoice;

import com.storecrm.storecrm.dto.supplier.SupplierDTO;
import com.storecrm.storecrm.dto.user.UserDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DTO for ReturnInvoice entity.
 * This class is used to transfer data between the layers of the application.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Schema(description = "DTO for returnfromcustomer invoice.")
public class ReturnInvoiceDTO {

    @Schema(description = "The unique identifier of the returnfromcustomer invoice.", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "The date of the returnfromcustomer invoice.", example = "2024-10-17")
    private Timestamp date;

    @NotNull
    @Schema(description = "The supplier associated with this returnfromcustomer invoice.")
    private SupplierDTO supplier;

    @NotNull
    @Positive
    @Schema(description = "The total amount for the returnfromcustomer invoice.", example = "150.75")
    private BigDecimal totalAmount;

    @NotNull
    @Schema(description = "The status of the returnfromcustomer invoice.", example = "Pending")
    private String status;

    @NotNull
    @Schema(description = "The user who created this returnfromcustomer invoice.")
    private UserDTO createdBy;
}
