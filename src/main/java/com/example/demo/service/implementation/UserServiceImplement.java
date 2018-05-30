package com.example.demo.service.implementation;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);

    }

    @Override
    @Transactional
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public User getByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    @Transactional
    public void delete(String email,String password) {
        userRepository.deleteByEmailAndPassword( email,password);

    }

    @Override
    @Transactional
    public User getById(int id) {
      return userRepository.findById(id);
    }



    @Override
    @Transactional
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
