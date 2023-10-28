package com.example.Food_Delivery_app.Repo;

import com.example.Food_Delivery_app.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food ,Long> {


}
