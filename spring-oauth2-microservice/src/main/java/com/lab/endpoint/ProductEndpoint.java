package com.lab.endpoint;

import com.lab.model.ProductItem;
import com.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class ProductEndpoint {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<ProductItem> sayHello() {
        return productService.getProducts();
    }
}
