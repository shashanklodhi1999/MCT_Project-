package com.example.Food_Delivery_app.Service;

import com.example.Food_Delivery_app.Model.Auth.AuthenticationToken;
import com.example.Food_Delivery_app.Model.User;
import com.example.Food_Delivery_app.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationTokenService authenticationTokenService;

    public String singUP(User user) {
        String email= user.getUserEmail();
        User existingUser=userRepo.findFirstByUserEmail(email);
        if(existingUser!=null){
             return "user is already singUp ";
        }
          String password = user.getPassword();
        try {
            String encryptPassword = PasswordEncryptor.encrypt(password);
            user.setPassword(encryptPassword);
            userRepo.save(user);
            return "user is created";

        } catch (NoSuchAlgorithmException e) {
            return "Invalid access";
        }
    }

    public String singIn(String userEmail, String password) {
        User existingUser=userRepo.findFirstByUserEmail(userEmail);
         if(existingUser==null){
             return "please sing up first";
         }
        try {
            String encryptPassword = PasswordEncryptor.encrypt(password);
            if(existingUser.getPassword().equals(encryptPassword)){
                AuthenticationToken token = new AuthenticationToken(existingUser);
                authenticationTokenService.createToken(token);
                return  token.getTokenValue();
            }
            else{
                return "password is wrong";
            }
        } catch (NoSuchAlgorithmException e) {
            return  "invalid access";
        }
    }

    public String userSingOut(String email, String tokenValue) {
        if(authenticationTokenService.authenticateToken(email ,tokenValue )){
            User existingUser = userRepo.findFirstByUserEmail(email);
            authenticationTokenService.singOut(tokenValue);

            return "User sing out is done ";
        }
        else{
            return  "Unauthenticate access";
        }
    }

    public User getHistoryByUserId(Integer userId) {
        return  userRepo.findById(userId).get();
    }
}
