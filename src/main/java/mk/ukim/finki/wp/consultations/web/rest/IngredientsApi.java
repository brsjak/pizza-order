package mk.ukim.finki.wp.consultations.web.rest;


import mk.ukim.finki.wp.consultations.exceptions.InvalidIngredientException;
import mk.ukim.finki.wp.consultations.exceptions.LimitExceededIngredientsException;
import mk.ukim.finki.wp.consultations.model.Ingredient;
import mk.ukim.finki.wp.consultations.model.Pizza;
import mk.ukim.finki.wp.consultations.service.IngredientsService;
import mk.ukim.finki.wp.consultations.service.PizzaService;
import mk.ukim.finki.wp.consultations.service.impl.PizzaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientsApi {
    private final IngredientsService ingredientsService;
    private final PizzaService pizzaService;

    public IngredientsApi(IngredientsService ingredientsService,PizzaService pizzaService) {
        this.ingredientsService = ingredientsService;
        this.pizzaService = pizzaService;
    }


    // Return all the ingredients in alphabetic order
    @GetMapping
    public List<Ingredient> getAll(){
        return ingredientsService.getAllIngredients().stream()
                .sorted(Comparator.comparing(Ingredient::getName))
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient createIngredient(@RequestParam("name") String name,
                                       @RequestParam("spicy") boolean spicy,
                                       @RequestParam("amount") float amount,
                                       @RequestParam("veggie") boolean veggie,
                                       HttpServletResponse response,
                                       UriComponentsBuilder builder){
        Ingredient result = this.ingredientsService.addIngredient(name,spicy,amount,veggie);
        response.setHeader("Location", String.valueOf(builder.path("/api/ingredients/{id}").buildAndExpand(builder.toUriString())));
        return result;
    }

    @GetMapping("/{id}")
    public Optional<Ingredient> getIngredient(@PathVariable String name){
        return this.ingredientsService.getIngredient(name);
    }

    // Return all the ingredients that have spicy property
    // Addition: Limit the spicy ingredients to 3
    @GetMapping
    public List<Ingredient> getSpicyIngredients(@RequestParam boolean spicy){
        List<Ingredient> ingredients = this.ingredientsService.getAllIngredients().stream().filter(i -> i.isVeggie() == spicy).collect(Collectors.toList());
        if(ingredients.size() > 3){
            throw new LimitExceededIngredientsException();
        }else{
            return ingredients;
        }
    }

    // Return all the pizzas that have the particular ingredient
    @GetMapping("/{id}/pizzas")
    public List<Pizza> getPizzasWithIngredient(@PathVariable String name){
        Ingredient ingredient = this.ingredientsService.getIngredient(name).orElseThrow(InvalidIngredientException::new);
        return this.pizzaService.getAllPizzas().stream().filter(p -> p.getIngredients().contains(ingredient)).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteIngredient(@PathVariable String name){
            this.ingredientsService.deleteIngredient(name);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Ingredient updateIngredient(@PathVariable String name,
                                       @RequestParam boolean spicy,
                                       @RequestParam float amount,
                                       @RequestParam boolean veggie){
        return this.ingredientsService.updateIngredient(name,spicy,amount,veggie);
    }
}
