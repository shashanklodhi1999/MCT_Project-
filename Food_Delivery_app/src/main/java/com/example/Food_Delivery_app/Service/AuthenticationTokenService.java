package com.example.Food_Delivery_app.Service;

import com.example.Food_Delivery_app.Model.Auth.AuthenticationToken;
import com.example.Food_Delivery_app.Repo.AuthenticationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationTokenService {
    @Autowired
    AuthenticationTokenRepo authenticationTokenRepo;

    public void createToken(AuthenticationToken token) {
        authenticationTokenRepo.save(token);
    }

    public boolean authenticateToken(String email, String tokenValue) {
        AuthenticationToken token = authenticationTokenRepo.findFirstByTokenValue(tokenValue);
        if(token!=null)
        {
            return token.getUser().getUserEmail().equals(email);
        }
        else
        {
            return false;
        }
    }

    public void singOut(String tokenValue) {
        AuthenticationToken token =authenticationTokenRepo.findFirstByTokenValue(tokenValue);
        authenticationTokenRepo.delete(token);
    }
}
