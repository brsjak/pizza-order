package mk.ukim.finki.wp.consultations.service;

import mk.ukim.finki.wp.consultations.model.Ingredient;
import mk.ukim.finki.wp.consultations.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface IngredientsService {
    List<Ingredient> getAllIngredients();
    Ingredient addIngredient(String name, boolean spicy, float amount, boolean veggie, List<Pizza> pizzas);
    Ingredient addIngredient(Ingredient ingredient);
    Optional<Ingredient> getIngredient(String name);
    void deleteIngredient(String name);
    Ingredient updateIngredient(String name,boolean spicy,float amount,boolean veggie);
}
