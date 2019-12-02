package mk.ukim.finki.wp.consultations.bootstrap;


import lombok.Getter;
import mk.ukim.finki.wp.consultations.model.Ingredient;
import mk.ukim.finki.wp.consultations.model.Pizza;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static final List<Pizza> pizzas = new ArrayList<>();
    public static final List<Ingredient> ingredients = new ArrayList<>();

    @PostConstruct
    public void init(){
        ingredients.add(new Ingredient("tomato sauce",true,100,true));
        ingredients.add(new Ingredient("fresh cream",true,500,false));
        ingredients.add(new Ingredient("mozzarella",false,500,false));
        ingredients.add(new Ingredient("bacon",false,2000,false));
        ingredients.add(new Ingredient("dough",false,5000,true));
        ingredients.add(new Ingredient("mushrooms",true,4000,true));
        ingredients.add(new Ingredient("ricotta",false,5000,false));
        ingredients.add(new Ingredient("pizza sauce",true,5000,true));
        ingredients.add(new Ingredient("olive oil",false,6000,true));
        ingredients.add(new Ingredient("pepperoni",true,4000,true));
        ingredients.add(new Ingredient("cheddar",true,3000,false));
        ingredients.add(new Ingredient("cheese",false,3000,false));
        ingredients.add(new Ingredient("ham",true,3000,false));
        ingredients.add(new Ingredient("onions",true,3000,true));
        ingredients.add(new Ingredient("barbecue sauce",true,3000,false));
        ingredients.add(new Ingredient("sausage",false,3000,false));
        ingredients.add(new Ingredient("chicken meat",false,3000,false));
        ingredients.add(new Ingredient("taleggio",false,3000,false));
        ingredients.add(new Ingredient("cascarpone",true,3000,false));
        ingredients.add(new Ingredient("gorgonzola",true,3000,false));
        ingredients.add(new Ingredient("parmesan",true,3000,false));
        ingredients.add(new Ingredient("beef",true,6000,false));
        ingredients.add(new Ingredient("mascarpone",true,6000,false));



        pizzas.add(new Pizza("Margherita",new ArrayList<Ingredient>(Arrays.asList(ingredients.get(0),ingredients.get(2))),true));
        pizzas.add(new Pizza("Carbonara",new ArrayList<Ingredient>(Arrays.asList(ingredients.get(1),ingredients.get(2),ingredients.get(3))),false));
        pizzas.add(new Pizza("Vegetariana",new ArrayList<Ingredient>(Arrays.asList(ingredients.get(0),ingredients.get(3))),true));
        pizzas.add(new Pizza("Calzone",new ArrayList<Ingredient>(Arrays.asList(ingredients.get(4),ingredients.get(6),ingredients.get(9),ingredients.get(7))),false));
        pizzas.add(new Pizza("Cheddar",new ArrayList<Ingredient>(Arrays.asList(ingredients.get(10),ingredients.get(0))),false));
        pizzas.add(new Pizza("Capricciosa",new ArrayList<Ingredient>(Arrays.asList(ingredients.get(0), ingredients.get(11),ingredients.get(12))),false));
        pizzas.add(new Pizza("Burger Classic",new ArrayList<Ingredient>(Arrays.asList(ingredients.get(21),ingredients.get(14),ingredients.get(1),ingredients.get(13))),false));
        pizzas.add(new Pizza("Burger Barbecue",new ArrayList<Ingredient>(Arrays.asList(ingredients.get(12),ingredients.get(16),ingredients.get(13))),false));
        pizzas.add(new Pizza("Pepperoni",new ArrayList<Ingredient>(Arrays.asList(ingredients.get(0),ingredients.get(2),ingredients.get(15))),true));
        pizzas.add(new Pizza("Quattro Formaggi",new ArrayList<Ingredient>(Arrays.asList(ingredients.get(7),ingredients.get(22),ingredients.get(19),ingredients.get(20))),false));


    }


}
