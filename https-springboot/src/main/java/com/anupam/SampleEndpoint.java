package com.anupam;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class SampleEndpoint {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}
