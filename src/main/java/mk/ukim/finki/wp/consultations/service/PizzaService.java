package mk.ukim.finki.wp.consultations.service;

import mk.ukim.finki.wp.consultations.model.Ingredient;
import mk.ukim.finki.wp.consultations.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaService {
    List<Pizza> getAllPizzas();
    Pizza addPizza(String name, List<Ingredient> ingredients,boolean veggie);
    Pizza addPizza(Pizza pizza);
    Optional<Pizza> getPizza(String name);
    void deletePizza(String name);
    void deletePizza(Pizza pizza);
}
