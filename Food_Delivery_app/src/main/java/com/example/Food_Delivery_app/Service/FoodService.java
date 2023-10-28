package com.example.Food_Delivery_app.Service;

import com.example.Food_Delivery_app.Model.Food;
import com.example.Food_Delivery_app.Repo.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepo foodRepo;

    public String createFood(Food food) {
        foodRepo.save(food);

        return  "Food is added in menu";
    }

    public Food getFoodById(Long id) {
        return foodRepo.findById(id).get();
    }

    public List<Food> getAllFoodItem() {
        return foodRepo.findAll();
    }

    public String updateFoodPrice(Integer price, Long id) {

        Food food =foodRepo.findById(id).get();
        food.setPrice(price);
        foodRepo.save(food);
        return "Food"+ food.getItemName()+ "price is updates as"+ price ;
    }

    public String deleteFoodItemById(Long id) {
        foodRepo.deleteById(id);
        return " Food  is removed from menu";
    }
}
