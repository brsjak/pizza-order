package mk.ukim.finki.wp.consultations.repository.inmemory;

import mk.ukim.finki.wp.consultations.bootstrap.DataHolder;
import mk.ukim.finki.wp.consultations.model.Pizza;
import mk.ukim.finki.wp.consultations.repository.PizzaRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Profile("in-memory-repo")
@Repository
public class PizzaRepositoryImpl implements PizzaRepository {
    @Override
    public List<Pizza> listPizzas() {
        return DataHolder.pizzas;
    }
}
