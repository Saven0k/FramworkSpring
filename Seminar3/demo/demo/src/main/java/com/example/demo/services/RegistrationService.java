package com.example.demo.services;

import com.example.demo.domains.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private NotificationService notificationService;
    private DataProcessingService service;
    private UserService userService;

    public RegistrationService() {
    }

    public UserService getUserService(){return userService;}
    public NotificationService getNotificationService(){return notificationService;}
    public DataProcessingService getService(){return service;}

    public void processRegistration(String name, int age,String email){
        User newUser = userService.createUser(name,age,email);
        notificationService.notifyUser(newUser);

        service.sortUsersByAge(service.getUserRepository().getUsers());
        service.filterUsersByAge(service.getUserRepository().getUsers(), newUser.getAge());
        service.calculateAvarageAge(service.getUserRepository().getUsers());

    }
}
