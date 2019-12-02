package mk.ukim.finki.wp.consultations.repository.jpa;

import mk.ukim.finki.wp.consultations.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaIngredientRepository extends JpaRepository<Ingredient,String> {
}
