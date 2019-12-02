package mk.ukim.finki.wp.consultations.bootstrap;


import lombok.Getter;
import mk.ukim.finki.wp.consultations.model.Pizza;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static final List<Pizza> pizzas = new ArrayList<>();


    @PostConstruct
    public void init(){
        pizzas.add(new Pizza("Margherita","(tomato sauce, mozzarella)"));
        pizzas.add(new Pizza("Carbonara","(fresh cream, mozzarella, bacon)"));
        pizzas.add(new Pizza("Vegetariana","(tomato sauce, mushrooms"));
        pizzas.add(new Pizza("Calzone","(dough, ricotta, pepperoni, pizza sauce, olive oil)"));
        pizzas.add(new Pizza("Cheddar","(cheddar, tomato sauce)"));
        pizzas.add(new Pizza("Capricciosa","(tomato sauce, cheese, ham)"));
        pizzas.add(new Pizza("Burger Classic","(barbecue sauce, beef, mozzarella, onions)"));
        pizzas.add(new Pizza("Burger Barbecue","(ham, chicken meat, onions)"));
        pizzas.add(new Pizza("Pepperoni","(tomato sauce, mozzarella, sausage)"));
        pizzas.add(new Pizza("Quattro Formaggi","(Taleggio, Mascarpone, Gorgonzola, Parmesan)"));


    }


}
