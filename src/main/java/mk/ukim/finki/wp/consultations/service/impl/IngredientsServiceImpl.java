package mk.ukim.finki.wp.consultations.service.impl;

import mk.ukim.finki.wp.consultations.exceptions.InvalidIngredientException;
import mk.ukim.finki.wp.consultations.model.Ingredient;
import mk.ukim.finki.wp.consultations.model.Pizza;
import mk.ukim.finki.wp.consultations.repository.IngredientRepository;
import mk.ukim.finki.wp.consultations.service.IngredientsService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    private final IngredientRepository ingredientRepository;

    public IngredientsServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.listIngredients();
    }

    @Override
    public Ingredient addIngredient(String name, boolean spicy, float amount, boolean veggie, List<Pizza> pizzas) {
        Ingredient ingredient = new Ingredient(name,spicy,amount,veggie,pizzas);
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Optional<Ingredient> getIngredient(String name) {
        return ingredientRepository.getIngredient(name);
    }

    @Override
    public void deleteIngredient(String name) {
        ingredientRepository.deleteIngredient(name);
    }

    @Override
    public Ingredient updateIngredient(String name, boolean spicy, float amount, boolean veggie) {
        Ingredient ingredient = ingredientRepository.getIngredient(name).orElseThrow(InvalidIngredientException::new);
            ingredient.setName(name);
            ingredient.setSpicy(spicy);
            ingredient.setAmount(amount);
            ingredient.setVeggie(veggie);
        return this.ingredientRepository.save(ingredient);
    }

}
