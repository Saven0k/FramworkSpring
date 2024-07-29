package com.example.demo.services;

import com.example.demo.domains.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepository userRepository;

    public UserRepository getUserRepository(){
        return userRepository;
    }

    /**
     * Метод который сортирует список users по возрасту.
     * @param users
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Метод который фильтрует список по заданному возрасту
     */
    public List<User> filterUsersByAge(List<User> users, int age){
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Метод считает средний возраст users  в списке
     */

    public double calculateAvarageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Метод добавляет user в список.
     */
    public void addUserToList(User user){
        userRepository.getUsers().add(user);
    }

}
