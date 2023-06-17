package com.internproj.shopcartsystem.productservice.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import com.internproj.shopcartsystem.productservice.entities.Product;
import com.internproj.shopcartsystem.productservice.repositories.ProductRepository;
import com.internproj.shopcartsystem.productservice.services.ProductService;


@SpringBootTest
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    public void testViewProductByProdId() {
        // Arrange
        int prodId = 123;
        Product product = new Product();
        when(productService.viewProductByProdId(prodId)).thenReturn(product);

        // Act
        Product result = productController.viewProductByProdId(prodId);

        // Assert
        assertNotNull(result);
        assertEquals(product, result);
        verify(productService).viewProductByProdId(prodId);
    }

    @Test
    public void testViewProductsByCategory() {
        // Arrange
        String category = "electronics";
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productService.viewProductsByCategory(category)).thenReturn(products);

        // Act
        List<Product> result = productController.viewProductsByCategory(category);

        // Assert
        assertNotNull(result);
        assertEquals(products, result);
        verify(productService).viewProductsByCategory(category);
    }

    @Test
    public void testViewProductsByProdName() {
        // Arrange
        String prodName = "iPhone";
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productService.viewProductsByProdName(prodName)).thenReturn(products);

        // Act
        List<Product> result = productController.viewProductsByProdName(prodName);

        // Assert
        assertNotNull(result);
        assertEquals(products, result);
        verify(productService).viewProductsByProdName(prodName);
    }

    @Test
    public void testAddProducts() {
        // Arrange
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productService.addProducts(products)).thenReturn(products);

        // Act
        List<Product> result = productController.addProducts(products);

        // Assert
        assertNotNull(result);
        assertEquals(products, result);
        verify(productService).addProducts(products);
    }

    @Test
    public void testAddProduct() {
        // Arrange
        Product product = new Product();
        when(productService.addProduct(product)).thenReturn(product);

        // Act
        Product result = productController.addProduct(product);

        // Assert
        assertNotNull(result);
        assertEquals(product, result);
        verify(productService).addProduct(product);
    }

    @Test
    public void testRemoveProduct() {
        // Arrange
        int prodId = 123;

        // Act
        String result = productController.removeProduct(prodId);

        // Assert
        assertEquals("deleted", result);
        verify(productService).removeProduct(prodId);
    }
}
