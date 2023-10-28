package com.example.Food_Delivery_app.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Orders.class,property="oderId")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oderId;

    private LocalDateTime oderDateAndTime;
    private String userCurrantAddress;

    //@NotBlank(message = "you can fill the status as Order_placed or Order_delivered ")
    private Status status;

    // mapping with user table
    @ManyToOne
    @JoinColumn(name = "Fk_user_id" )
    User user;

    // mapping with Food table
    @ManyToMany
    @JoinColumn(name = "Fk_food_id" )
     List<Food> food;

}
