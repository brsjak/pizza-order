package mk.ukim.finki.wp.consultations.repository;


import mk.ukim.finki.wp.consultations.model.Ingredient;
import mk.ukim.finki.wp.consultations.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository {
    List<Pizza> listPizzas();
    Pizza savePizza(Pizza pizza);
    Pizza savePizza(String name, List<Ingredient> ingredients,boolean veggie);
    Optional<Pizza> getPizzaByName(String name);
    void deletePizza(String name);
    void deletePizza(Pizza pizza);
}
