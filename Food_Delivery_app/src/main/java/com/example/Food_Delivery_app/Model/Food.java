package com.example.Food_Delivery_app.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    private String itemName;

    // you can order max 5 quantity at a time
    @Size(min = 1 ,max = 5)
    private String quantity ;

    private Integer price;

    private String extraItem;

    private String description ;

   // @ManyToMany(mappedBy = "food")
    //List<Orders> orders;



}
