package mk.ukim.finki.wp.consultations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name="ingredients")
public class Ingredient {
    @Id
    private String name;

    private boolean spicy;

    private float amount;

    private boolean veggie;

    @ManyToMany(mappedBy = "ingredients")
    private List<Pizza> pizzas;

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public Ingredient(String name, boolean spicy, float amount, boolean veggie, List<Pizza> pizzas) {
        this.name = name;
        this.spicy = spicy;
        this.amount = amount;
        this.veggie = veggie;
        this.pizzas = pizzas;
    }


    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isVeggie() {
        return veggie;
    }

    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }
}
