package com.example.Food_Delivery_app.Controller.Service;

import com.example.Food_Delivery_app.Model.Admin;
import com.example.Food_Delivery_app.Model.Food;
import com.example.Food_Delivery_app.Model.Orders;
import com.example.Food_Delivery_app.Model.Status;
import com.example.Food_Delivery_app.Service.AdminService;
import com.example.Food_Delivery_app.Service.FoodService;
import com.example.Food_Delivery_app.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    FoodService foodService;
    @PostMapping("Foods")
    public String addFood(@RequestBody Food food){
        return  foodService.createFood(food);
    }
    @GetMapping("FoodItem")
    public Food getFoodById(@RequestParam Long id){
        return foodService.getFoodById(id);
    }
    @GetMapping("AllFoodItem")
    public List<Food> getAllFood(){
        return  foodService.getAllFoodItem();
    }
    @PutMapping("Food_Price")
    public String updateFoodPrice(@RequestParam Integer price , @RequestParam Long id){
        return foodService.updateFoodPrice(price ,id);
    }
    @DeleteMapping("Food")
    public String deleteFoodItemById(@RequestParam Long id){
          return  foodService.deleteFoodItemById(id);
    }

    @Autowired
    OrderService orderService;
    @GetMapping("AllOrders")
    public List<Orders> getAllOrders(){
        return orderService.getAllOrders();
    }

    @Autowired
    AdminService adminService;
    @PostMapping("Admin")
    public  String postAdmin(@RequestBody Admin admin){
        return adminService.createAdmin(admin);

    }
    @PutMapping("Order_status")
    public String setStatus(@RequestParam Status status , @RequestParam Integer id){
        return  orderService.setOrderStatus(status,id);
    }


}
