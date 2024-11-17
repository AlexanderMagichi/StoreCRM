package com.storecrm.storecrm.dto.supplier;

import jakarta.validation.constraints.*;
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
}
