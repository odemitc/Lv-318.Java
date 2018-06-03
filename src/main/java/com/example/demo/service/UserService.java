package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User update(User user);

    void deleteById(int id);

    User getById(int id);

    User getByEmailAndPassword(String email, String password);

    List<User> getAll();
}
