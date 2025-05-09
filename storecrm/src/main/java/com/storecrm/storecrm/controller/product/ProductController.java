package com.storecrm.storecrm.controller.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/get_product")
    public ResponseEntity<String> getProducts() {
        return ResponseEntity.ok("You have connection to server!");
    }
}
