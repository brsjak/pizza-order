package mk.ukim.finki.wp.consultations.service.impl;

import mk.ukim.finki.wp.consultations.model.Ingredient;
import mk.ukim.finki.wp.consultations.repository.IngredientRepository;
import mk.ukim.finki.wp.consultations.service.IngredientsService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
