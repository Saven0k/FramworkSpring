package com.example.demo.services;

import com.example.demo.domains.User;
import org.springframework.stereotype.Service;



/**
 * Сервис для создания пользователя(User)
 */
@Service
public class UserService {
    private NotificationService notificationService;

    public UserService(NotificationService notificationService){this.notificationService=notificationService;}

    public User createUser(String name, int age, String email){
        User user = new User(name,age,email);
        notificationService.notifyUser(user);
        return user;
    }
}
