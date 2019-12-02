package mk.ukim.finki.wp.consultations.repository.jpa;

import mk.ukim.finki.wp.consultations.model.Ingredient;
import mk.ukim.finki.wp.consultations.repository.IngredientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JpaIngredientRepositoryImpl implements IngredientRepository {
    private final JpaIngredientRepository jpaIngredientRepository;

    public JpaIngredientRepositoryImpl(JpaIngredientRepository jpaIngredientRepository) {
        this.jpaIngredientRepository = jpaIngredientRepository;
    }

    @Override
    public List<Ingredient> listIngredients() {
        return jpaIngredientRepository.findAll();
    }
}
