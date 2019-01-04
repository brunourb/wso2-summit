package com.lab.endpoint;

import com.lab.model.ProductClient;
import com.lab.model.ProductItem;
import com.lab.service.ProductClientService;
import com.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class ProductEndpoint {

    @Autowired
    ProductService productService;

    @Autowired
    ProductClientService productClientService;


    @GetMapping("/products")
    public List<ProductItem> getProducts() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return productService.getProducts();
    }

    @GetMapping("/clients")
    public List<ProductClient> getClients() {
        return productClientService.getCliens();
    }
}
