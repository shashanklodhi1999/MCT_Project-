package com.example.Food_Delivery_app.Repo;

import com.example.Food_Delivery_app.Model.Auth.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationTokenRepo extends JpaRepository<AuthenticationToken ,Long> {

    AuthenticationToken findFirstByTokenValue(String tokenValue);
}
