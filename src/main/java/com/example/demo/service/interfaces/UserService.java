package com.example.demo.service.interfaces;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User update(User user);

    void delete(int id);

    void delete (String email);

    User getById(int id);

    User getByEmail(String email);

    List<User> getAll();
}
