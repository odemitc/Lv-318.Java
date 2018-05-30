package com.example.demo.repository;


import com.example.demo.entity.Feedback;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByEmailAndPassword(String email, String password);

    void deleteByEmailAndPassword(String email,String password);

}
