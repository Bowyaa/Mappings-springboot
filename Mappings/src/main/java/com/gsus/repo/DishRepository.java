package com.gsus.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsus.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Long>{

}
