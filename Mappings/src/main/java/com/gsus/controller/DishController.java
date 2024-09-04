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

import com.gsus.entity.Dish;
import com.gsus.serv.DishService;

@RestController
@RequestMapping("/api/dishes")
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping("/create")
    public Dish createDish(@RequestBody Dish dish) {
        return dishService.save(dish);
    }

    @GetMapping("/all")
    public List<Dish> getAllDishes() {
        return dishService.findAll();
    }

    @GetMapping("/search{id}")
    public Optional<Dish> getDishById(@PathVariable Long id) {
        return dishService.findById(id);
    }

    @PutMapping("/update{id}")
    public Dish updateDish(@PathVariable Long id, @RequestBody Dish dishDetails) {
        Dish dish = dishService.findById(id).orElseThrow();
        dish.setName(dishDetails.getName());
        return dishService.save(dish);
    }

    @DeleteMapping("/del{id}")
    public void deleteDish(@PathVariable Long id) {
        dishService.deleteById(id);
    }
}
