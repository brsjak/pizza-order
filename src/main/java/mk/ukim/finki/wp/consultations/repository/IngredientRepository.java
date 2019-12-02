package mk.ukim.finki.wp.consultations.repository;

import mk.ukim.finki.wp.consultations.model.Ingredient;

import java.util.List;

public interface IngredientRepository {
    List<Ingredient> listIngredients();
}
