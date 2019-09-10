package com.anupam.vo;

public class PizzaRanking {
    private int pizzaId;
    private String rank;

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public PizzaRanking(int pizzaId, String rank) {
        this.pizzaId = pizzaId;
        this.rank = rank;
    }
}
