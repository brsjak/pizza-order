package mk.ukim.finki.wp.consultations.repository.jpa.impl;

import mk.ukim.finki.wp.consultations.model.Pizza;
import mk.ukim.finki.wp.consultations.repository.PizzaRepository;
import mk.ukim.finki.wp.consultations.repository.jpa.JpaPizzaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
