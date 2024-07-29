package com.example.demo.services;

import com.example.demo.domains.User;
import org.springframework.stereotype.Service;


/**
 * Сервис для вывода информации о user.
 */
@Service
public class NotificationService {
    public void notifyUser(User user){
        System.out.println("A new user has been created: " + user.getName());
    }
}
