package mk.ukim.finki.wp.consultations.repository.jpa.impl;

import mk.ukim.finki.wp.consultations.model.Ingredient;
import mk.ukim.finki.wp.consultations.model.Pizza;
import mk.ukim.finki.wp.consultations.repository.PizzaRepository;
import mk.ukim.finki.wp.consultations.repository.jpa.JpaPizzaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaPizzaRepositoryImpl implements PizzaRepository {
    private final JpaPizzaRepository jpaPizzaRepository;

    public JpaPizzaRepositoryImpl(JpaPizzaRepository jpaPizzaRepository) {
        this.jpaPizzaRepository = jpaPizzaRepository;
    }

    @Override
    public List<Pizza> listPizzas() {
        return jpaPizzaRepository.findAll();
    }

    @Override
    public Pizza savePizza(Pizza pizza) {
        return jpaPizzaRepository.save(pizza);
    }

    @Override
    public Pizza savePizza(String name, List<Ingredient> ingredients, boolean veggie) {
        Pizza pizza = new Pizza(name,ingredients,veggie);
        return jpaPizzaRepository.save(pizza);
    }

    @Override
    public Optional<Pizza> getPizzaByName(String name) {
        return jpaPizzaRepository.findById(name);
    }

    @Override
    public void deletePizza(String name) {
        jpaPizzaRepository.deleteById(name);
    }

    @Override
    public void deletePizza(Pizza pizza) {
        jpaPizzaRepository.delete(pizza);
    }
}
