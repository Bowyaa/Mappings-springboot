package com.gsus.serv;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsus.entity.Dish;
import com.gsus.repo.DishRepository;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public Optional<Dish> findById(Long id) {
        return dishRepository.findById(id);
    }

    public void deleteById(Long id) {
        dishRepository.deleteById(id);
    }
}
