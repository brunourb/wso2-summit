package com.lab.service;


import com.lab.model.ProductClient;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductClientService {

    public List<ProductClient> getCliens() {
        return Arrays.asList(new ProductClient("Safra", "Brazil"),
                new ProductClient("TempoAssist", "Brazil"));
    }

}
