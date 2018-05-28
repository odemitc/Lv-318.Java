package com.example.demo.repository;


import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByEmail(String email);

    void deleteById(int id);

    void deleteByEmail(String email);

}
