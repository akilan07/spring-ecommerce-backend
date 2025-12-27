package com.akisha.spring_ecommerce_backend;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.akisha.spring_ecommerce_backend.config.MongoIntegrationTest;
import com.akisha.spring_ecommerce_backend.config.MongoTestContainerConfig;
import com.akisha.spring_ecommerce_backend.dto.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@MongoIntegrationTest
@ImportTestcontainers(MongoTestContainerConfig.class)
class ProductControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void contextLoads() {
        // If this runs, Mongo container MUST be running
    }

    @Test
    void shouldSaveProductInMongoDB() throws Exception {
        Product product = ProductFactory.getProduct();

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated());
    }

}
