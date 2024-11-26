package com.storecrm.storecrm.dto.supplier;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for supplier operations.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierDTO {

    private long id;

    @NotBlank(message = "Supplier name cannot be empty")
    @Size(min = 3, max = 100, message = "Supplier name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Address cannot be empty")
    @Size(min = 5, max = 200, message = "Address must be between 5 and 200 characters")
    private String address;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^(\\+\\d{1,2}\\s?)?\\(?\\d{1,4}\\)?[\\s-]?\\d{1,4}[\\s-]?\\d{1,4}$", message = "Invalid phone number format")
    private String phone;

    /**
     * DTO for supplier response.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class SupplierResponse {
        private Long id;
        private String name;
        private String address;
        private String email;
        private String phone;
    }

    /**
     * DTO for creating a new supplier.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Create {
        @NotBlank(message = "Supplier name cannot be empty")
        @Size(min = 3, max = 100, message = "Supplier name must be between 3 and 100 characters")
        private String name;

        @NotBlank(message = "Address cannot be empty")
        @Size(min = 5, max = 200, message = "Address must be between 5 and 200 characters")
        private String address;

        @Email(message = "Invalid email format")
        private String email;

        /**
         * This regular expression used to check the correctness of the telephone number format.
         */
        @Pattern(regexp = "^(\\+\\d{1,2}\\s?)?\\(?\\d{1,4}\\)?[\\s-]?\\d{1,4}[\\s-]?\\d{1,4}$", message = "Invalid phone number format")
        private String phone;
    }
}
