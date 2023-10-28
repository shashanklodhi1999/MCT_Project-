package com.example.Food_Delivery_app.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer adminId;
     @Email
     private String adminEmail;
     private String password;




}
