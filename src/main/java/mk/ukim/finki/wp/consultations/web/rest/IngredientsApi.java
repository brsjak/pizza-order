package mk.ukim.finki.wp.consultations.web.rest;


import mk.ukim.finki.wp.consultations.model.Ingredient;
import mk.ukim.finki.wp.consultations.service.IngredientsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientsApi {
    private final IngredientsService ingredientsService;

    public IngredientsApi(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping()
    public List<Ingredient> getAll(){
        return ingredientsService.getAllIngredients();
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
        response.setHeader("Ingredient", String.valueOf(builder.path("/api/ingredients/{id}").buildAndExpand(builder.toUriString())));
        return result;
    }

    @GetMapping("/{id}")
    public Optional<Ingredient> getIngredient(@PathVariable String name){
        return this.ingredientsService.getIngredient(name);
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
