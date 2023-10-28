package com.example.Food_Delivery_app.Service;

import com.example.Food_Delivery_app.Model.Food;
import com.example.Food_Delivery_app.Model.Orders;
import com.example.Food_Delivery_app.Model.Status;
import com.example.Food_Delivery_app.Model.User;
import com.example.Food_Delivery_app.Repo.FoodRepo;
import com.example.Food_Delivery_app.Repo.OrderRepo;
import com.example.Food_Delivery_app.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    UserRepo userRepo;

    public List<Orders> getAllOrders() {
         return orderRepo.findAll();
    }

    @Autowired
    AuthenticationTokenService authenticationTokenService;
    public String bookOrder(String email, String tokenValue, Orders orders) {
        if(authenticationTokenService.authenticateToken(email ,tokenValue )){
            User existingUser = userRepo.findFirstByUserEmail(email);
            orders.setUser(existingUser);
            orderRepo.save(orders);
            return  " order genrated";
        }
        else{
            return  "Unauthenticate access";
        }
    }

    public Orders getOrderById(Integer id) {
        return orderRepo.findById(id).get();
    }

    public String setOrderStatus(Status status, Integer id) {
        Orders order=orderRepo.findById(id).get();
        order.setStatus(status);
        orderRepo.save(order);

        return "status changed";
    }

    public String cencelOrder(Integer orderId) {
        orderRepo.deleteById(orderId);
        return "Order is canceled ";
    }
}
