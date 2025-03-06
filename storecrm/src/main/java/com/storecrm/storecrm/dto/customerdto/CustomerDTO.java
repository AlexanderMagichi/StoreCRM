package com.storecrm.storecrm.dto.customerdto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "DTO for transferring customerservice data")
public class CustomerDTO {

    @Schema(description = "The unique identifier of the customerservice", example = "1", required = true)
    private Long id;

    @Schema(description = "The name of the customerservice", example = "John Doe", required = true)
    private String name;

    @Email(message = "Invalid email format")
    @Schema(description = "The email of the customerservice", example = "john.doe@example.com", required = true)
    private String email;

    @Pattern(regexp = "\\+?\\d{10,15}", message = "Invalid phone number")
    @Schema(description = "The phone number of the customerservice", example = "+1234567890")
    private String phone;

    @Schema(description = "The address of the customerservice", example = "123 Main St, Springfield")
    private String address;
}
