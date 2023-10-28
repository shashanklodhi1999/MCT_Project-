package com.example.Food_Delivery_app.Service;

import com.example.Food_Delivery_app.Model.Orders;
import com.example.Food_Delivery_app.Repo.OrderRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class BillGenrate {

    public static Integer bill(Integer price ,Integer quantity){
        Integer extra=40;
        Integer cal=(price*quantity);
        Integer addTax=cal*18;
        Integer total=addTax/100;
        Integer subTotal=total+extra;
        return  subTotal;

    }
}
