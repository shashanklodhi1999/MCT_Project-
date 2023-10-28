package com.example.Food_Delivery_app.Repo;

import com.example.Food_Delivery_app.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User ,Integer> {

    User findFirstByUserEmail(String email);
}
