package org.uaTransport.service;

import org.uaTransport.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User update(User user);

    void deleteById(int id);

    User getById(int id);

    User getByEmailAndPassword(String email, String password);

    List<User> getAll();
}
