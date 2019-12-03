package mk.ukim.finki.wp.consultations.repository.inmemory;

import mk.ukim.finki.wp.consultations.bootstrap.DataHolder;
import mk.ukim.finki.wp.consultations.model.Ingredient;
import mk.ukim.finki.wp.consultations.model.Pizza;
import mk.ukim.finki.wp.consultations.repository.PizzaRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Profile("in-memory-repo")
@Repository
public class PizzaRepositoryImpl implements PizzaRepository {
    @Override
    public List<Pizza> listPizzas() {
        return DataHolder.pizzas;
    }

    @Override
    public Pizza savePizza(Pizza pizza) {
        return null;
    }

    @Override
    public Pizza savePizza(String name, List<Ingredient> ingredients, boolean veggie) {
        return null;
    }

    @Override
    public Optional<Pizza> getPizzaByName(String name) {
        return Optional.empty();
    }

    @Override
    public void deletePizza(String name) {

    }

    @Override
    public void deletePizza(Pizza pizza) {

    }
}
