package com.example.Food_Delivery_app.Service;

import com.example.Food_Delivery_app.Model.Admin;
import com.example.Food_Delivery_app.Repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;

    public String createAdmin(Admin admin) {
        adminRepo.save(admin);
        return "Admin created";
    }
}
