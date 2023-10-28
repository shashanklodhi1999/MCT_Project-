package com.example.Food_Delivery_app.Repo;

import com.example.Food_Delivery_app.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders ,Integer> {



}
