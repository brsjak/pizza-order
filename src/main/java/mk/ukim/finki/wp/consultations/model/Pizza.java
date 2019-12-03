package mk.ukim.finki.wp.consultations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name="pizzas")
public class Pizza {
    @Id
    private String name;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<Ingredient> ingredients;

    private boolean veggie;

    public Pizza(String name, List<Ingredient> ingredients, boolean veggie) {
        this.name = name;
        this.ingredients = ingredients;
        this.veggie = veggie;
    }

    public void addIngredients(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        ingredient.getPizzas().add(this);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isVeggie() {
        return veggie;
    }

    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
