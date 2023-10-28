package com.example.Food_Delivery_app.Controller.Service;

import com.example.Food_Delivery_app.Model.Orders;
import com.example.Food_Delivery_app.Model.User;
import com.example.Food_Delivery_app.Service.OrderService;
import com.example.Food_Delivery_app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("SingUp")
    public String singUp(@RequestBody User user){
        return userService.singUP(user);
    }
    @PostMapping("SingIn")
    public String singIn(@RequestParam String userEmail ,@RequestParam String password){
        return userService.singIn(userEmail ,password);
    }
    @DeleteMapping("SingOut")
    public String userSingOut(@RequestParam String email ,@RequestParam String tokenValue){
        return userService.userSingOut(email ,tokenValue);
    }

    @Autowired
    OrderService orderService;
    @PostMapping("order")
    public String bookOrder(@RequestParam String email , @RequestParam String tokenValue , @RequestBody Orders orders){
        return orderService.bookOrder(email,tokenValue , orders);
    }
    @GetMapping("Order")
    public Orders getOrder( @RequestParam Integer id){
        return orderService.getOrderById(id);
    }

    @DeleteMapping("CancelOrder")
    public String cancelOrder( @RequestParam Integer orderId){
        return  orderService.cencelOrder(orderId);
    }

    @GetMapping("UserHistory")
    public User getHistoryByUserId(@RequestParam Integer userId){
        return userService.getHistoryByUserId(userId);
    }

}
