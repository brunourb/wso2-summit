package com.anupam.endpoint;

import com.anupam.vo.PizzaRanking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service/rank")
public class RankingEndpoint {
    private static List<PizzaRanking> list = new ArrayList<>();

    @PostConstruct
    public void init() {
        list.add(new PizzaRanking(1, "Good"));
        list.add(new PizzaRanking(2, "Awesome"));
        list.add(new PizzaRanking(3, "Bad"));
        list.add(new PizzaRanking(4, "Tasty"));
        list.add(new PizzaRanking(5, "Very Good"));
        list.add(new PizzaRanking(6, "Delicious"));

    }

    @GetMapping("/pizzarank/{Id}")
    public PizzaRanking getPizzaRank(@PathVariable("Id") Integer Id) throws Exception {
        if (Id == 0) {
            throw new Exception("No Pizza Found");
        }
        return list.get(Id - 1);
    }
}
