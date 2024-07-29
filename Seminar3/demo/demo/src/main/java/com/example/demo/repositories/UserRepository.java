package com.example.demo.repositories;

import com.example.demo.domains.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Как бы база данных. Место куда сохраняються users.
 */
@Component
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUser(List<User> users) {
        this.users = users;
    }

}
