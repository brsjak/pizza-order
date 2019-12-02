package mk.ukim.finki.wp.consultations.repository.jpa;

import mk.ukim.finki.wp.consultations.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPizzaRepository extends JpaRepository<Pizza,String> {
}
