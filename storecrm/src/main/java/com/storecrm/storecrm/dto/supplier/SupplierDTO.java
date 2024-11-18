package com.storecrm.storecrm.dto.supplier;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

    @Builder
    public SupplierDTO(Long id, String name, String address, String email, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

        @Data
        @NoArgsConstructor
        @Builder
        public static class SupplierResponse {
            private Long id;
            private String name;
            private String address;
            private String email;
            private String phone;
        }

        @Data
        @NoArgsConstructor
        @Builder
        public static class Create {
            private String name;
            private String address;
            private String email;
            private String phone;
        }

    }
