package com.example.Food_Delivery_app.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=User.class,property="userId")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer userId;

    @NotBlank(message = "Full Name is required")
    private  String  fullName;

    @NotBlank(message = "Username is required")
    private  String username;


    @Min(18)
    private  String  age;

    @Size(min=10,max=12)
    @Pattern(regexp = "^[0-9]+$", message = "contacts should be just numbers!!")
    private  String  phoneNo;

    @Email
    private  String  userEmail;

    private  String  password;
    private  String  address;

    @OneToMany(mappedBy = "user")
    List<Orders> orders;

}
