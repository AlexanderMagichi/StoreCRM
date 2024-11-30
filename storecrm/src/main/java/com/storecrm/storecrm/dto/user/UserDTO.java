package com.storecrm.storecrm.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "DTO representing a user in the system")
public class UserDTO {

    @Schema(description = "Unique identifier for the user", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Schema(description = "Username of the user", example = "john_doe")
    private String username;

    @NotBlank(message = "Role cannot be empty")
    @Size(min = 3, max = 20, message = "Role must be between 3 and 20 characters")
    @Schema(description = "Role assigned to the user", example = "admin")
    private String role;
}
