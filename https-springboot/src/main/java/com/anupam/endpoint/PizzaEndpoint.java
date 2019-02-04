package com.anupam.endpoint;


import com.anupam.vo.Pizza;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaEndpoint {
    static List<Pizza> list = new ArrayList<>();

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/menu")
    public List<Pizza> getMenu() {
        list.add(new Pizza("BBQ Chicken Bacon", "Grilled white chicken, hickory-smoked bacon and fresh sliced onions in barbeque sauce", 10));
        list.add(new Pizza("Chicken Parmesan", "Grilled chicken, fresh tomatoes, feta and mozzarella cheese", 28.90));
        list.add(new Pizza("Chilly Chicken Cordon Bleu", "Spinash Alfredo sauce topped with grilled chicken, ham, onions and mozzarella", 25.99));
        list.add(new Pizza("Double Bacon 6Cheese", "Hickory-smoked bacon, Julienne cut Canadian bacon, Parmesan, mozzarella, Romano, Asiago and and Fontina cheese", 20));
        list.add(new Pizza("Garden Fresh", "Slices onions and green peppers, gourmet mushrooms, black olives and ripe Roma tomatoes", 24));
        list.add(new Pizza("Grilled Chicken Club", "Grilled white chicken, hickory-smoked bacon and fresh sliced onions topped with Roma tomatoes", 26));
        return list;
    }
}
