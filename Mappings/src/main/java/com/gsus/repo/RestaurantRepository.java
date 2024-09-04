package com.gsus.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gsus.entity.Restaurant;
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

}
