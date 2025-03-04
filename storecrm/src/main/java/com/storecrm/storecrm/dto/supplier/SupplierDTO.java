package com.storecrm.storecrm.dto.supplier;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for supplierservice operations.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO representing a supplierservice for operations in the system.")
public class SupplierDTO {

    @Schema(description = "Unique identifier for the supplierservice", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private long id;

    @NotBlank(message = "Supplier name cannot be empty")
    @Size(min = 3, max = 100, message = "Supplier name must be between 3 and 100 characters")
    @Schema(description = "Name of the supplierservice", example = "Supplier Inc.")
    private String name;

    @NotBlank(message = "Address cannot be empty")
    @Size(min = 5, max = 200, message = "Address must be between 5 and 200 characters")
    @Schema(description = "Address of the supplierservice", example = "123 Supplier St, City, Country")
    private String address;

    @Email(message = "Invalid email format")
    @Schema(description = "Email address of the supplierservice", example = "supplierservice@domain.com")
    private String email;

    @Pattern(regexp = "^(\\+\\d{1,2}\\s?)?\\(?\\d{1,4}\\)?[\\s-]?\\d{1,4}[\\s-]?\\d{1,4}$", message = "Invalid phone number format")
    @Schema(description = "Phone number of the supplierservice", example = "+1234567890")
    private String phone;

    /**
     * DTO for supplierservice response.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "Response DTO for supplierservice data.")
    public static class SupplierResponse {
        @Schema(description = "Unique identifier for the supplierservice", example = "1")
        private Long id;

        @Schema(description = "Name of the supplierservice", example = "Supplier Inc.")
        private String name;

        @Schema(description = "Address of the supplierservice", example = "123 Supplier St, City, Country")
        private String address;

        @Schema(description = "Email address of the supplierservice", example = "supplierservice@domain.com")
        private String email;

        @Schema(description = "Phone number of the supplierservice", example = "+1234567890")
        private String phone;
    }

    /**
     * DTO for creating a new supplierservice.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Schema(description = "DTO for creating a new supplierservice in the system.")
    public static class Create {
        @NotBlank(message = "Supplier name cannot be empty")
        @Size(min = 3, max = 100, message = "Supplier name must be between 3 and 100 characters")
        @Schema(description = "Name of the new supplierservice", example = "New Supplier Ltd.")
        private String name;

        @NotBlank(message = "Address cannot be empty")
        @Size(min = 5, max = 200, message = "Address must be between 5 and 200 characters")
        @Schema(description = "Address of the new supplierservice", example = "456 New Supplier Rd, City, Country")
        private String address;

        @Email(message = "Invalid email format")
        @Schema(description = "Email address of the new supplierservice", example = "newsupplier@domain.com")
        private String email;

        @Pattern(regexp = "^(\\+\\d{1,2}\\s?)?\\(?\\d{1,4}\\)?[\\s-]?\\d{1,4}[\\s-]?\\d{1,4}$", message = "Invalid phone number format")
        @Schema(description = "Phone number of the new supplierservice", example = "+1234567890")
        private String phone;
    }
}
