package com.storecrm.storecrm.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO {
    private Long id;

    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "\\+?\\d{10,15}", message = "Invalid phone number")
    private String phone;

    private String address;
}
