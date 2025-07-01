package com.storecrm.storecrm;

import com.storecrm.storecrm.StorecrmApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = StorecrmApplication.class)
@ActiveProfiles("test")
public class SimpleContextLoadTest {
    @Test
    void contextLoads() {
        // Test logic
    }
}


