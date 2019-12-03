package mk.ukim.finki.wp.consultations.service.impl;

import mk.ukim.finki.wp.consultations.model.Ingredient;
import mk.ukim.finki.wp.consultations.model.Pizza;
import mk.ukim.finki.wp.consultations.repository.PizzaRepository;
import mk.ukim.finki.wp.consultations.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;

    // We must add a qualifier in order the service to know which implementation of the pizzaRepository to use
    // Remember,there are two implementations of the PizzaRepository
    // We'll use the jpa pizza implementation

    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.listPizzas();
    }

    @Override
    public Pizza addPizza(Pizza pizza) {
        return pizzaRepository.savePizza(pizza);
    }

    @Override
    public Optional<Pizza> getPizza(String name) {
        return pizzaRepository.getPizzaByName(name);
    }

    @Override
    public void deletePizza(String name) {
        pizzaRepository.deletePizza(name);
    }

    @Override
    public void deletePizza(Pizza pizza) {
        pizzaRepository.deletePizza(pizza);
    }
}
