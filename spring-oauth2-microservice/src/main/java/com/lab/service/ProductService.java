package com.lab.service;


import com.lab.model.ProductItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<ProductItem> getProducts() {
        List<ProductItem> list = new ArrayList<>();

        list.add(new ProductItem("API Manager", "2.5.0", 10000));
        list.add(new ProductItem("API Manager", "2.6.0", 10000));
        list.add(new ProductItem("Enterprise Integrator", "6.3.0", 10000));
        list.add(new ProductItem("Identity Server", "5.5.0", 15000));
        list.add(new ProductItem("Stream Processor", "4.3.0", 10000));
        return list;
    }
}
