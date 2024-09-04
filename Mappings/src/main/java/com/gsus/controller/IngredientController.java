package com.gsus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsus.entity.Ingredient;
import com.gsus.serv.IngredientService;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @PostMapping("/create")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.save(ingredient);
    }

    @GetMapping("/all")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.findAll();
    }

    @GetMapping("/search{id}")
    public Optional<Ingredient> getIngredientById(@PathVariable Long id) {
        return ingredientService.findById(id);
    }

    @PutMapping("/update{id}")
    public Ingredient updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredientDetails) {
        Ingredient ingredient = ingredientService.findById(id).orElseThrow();
        ingredient.setName(ingredientDetails.getName());
        return ingredientService.save(ingredient);
    }

    @DeleteMapping("/del{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteById(id);
    }
}