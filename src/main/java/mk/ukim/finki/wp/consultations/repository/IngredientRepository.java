package mk.ukim.finki.wp.consultations.repository;

import mk.ukim.finki.wp.consultations.model.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {
    List<Ingredient> listIngredients();
    Ingredient save(Ingredient ingredient);
    Optional<Ingredient> getIngredient(String name);
    void deleteIngredient(String name);
}
