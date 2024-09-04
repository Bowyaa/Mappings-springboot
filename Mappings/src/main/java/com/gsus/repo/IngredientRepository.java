package com.gsus.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsus.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{

}
