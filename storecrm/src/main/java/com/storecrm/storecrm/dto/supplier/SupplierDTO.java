package com.storecrm.storecrm.dto.supplier;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierDTO {

    private long id;
    private String name;
    private String address;
    private String email;
    private String phone;
}
