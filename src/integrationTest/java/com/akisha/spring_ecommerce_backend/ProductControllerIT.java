package com.akisha.spring_ecommerce_backend;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.akisha.spring_ecommerce_backend.config.MongoTestContainerConfig;
import com.akisha.spring_ecommerce_backend.dto.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class ProductControllerIT extends MongoTestContainerConfig{

    private final MockMvc mockMvc;

    private final ObjectMapper objectMapper;

    ProductControllerIT(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

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
