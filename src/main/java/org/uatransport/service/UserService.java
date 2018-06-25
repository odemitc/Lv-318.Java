package org.uatransport.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.uatransport.entity.User;
import org.uatransport.entity.dto.LoginDTO;
import org.uatransport.entity.dto.UserDTO;

import java.security.Principal;
import java.util.List;

public interface UserService {

    User addUser(UserDTO user);

    User update(User user);

    void deleteById(int id);

    User getById(int id);
    User getUser(Principal principal);

   String signin(LoginDTO loginDTO) ;
   String signup(UserDTO user);
    List<User> getAll();
}
