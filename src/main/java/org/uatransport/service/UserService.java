package org.uatransport.service;

import java.util.List;
import org.uatransport.entity.User;

public interface UserService {

  User addUser(User user);

  User update(User user);

  void deleteById(int id);

  User getById(int id);

  User getByEmailAndPassword(String email, String password);

  List<User> getAll();
}
