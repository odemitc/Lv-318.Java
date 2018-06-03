package com.example.demo.service.implementation;

import com.example.demo.entity.User;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {


    private final UserRepository userRepository;

    @Override
    @Transactional
    public User addUser(User user) {
        if(user == null){
            throw new IllegalArgumentException("user shoud not be empty");
        }
        return userRepository.saveAndFlush(user);

    }

    @Override
    @Transactional
    public User update(User user)
    {    if(user==null){
        throw new IllegalArgumentException("can not update empty user");
    }
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getByEmailAndPassword(String email, String password) {
        if(email==null || password==null){
            throw new IllegalArgumentException("Parameter should not be null");
        }try {
            return userRepository.findByEmailAndPassword(email, password);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("user not found" );

        }
    }

    @Override
    @Transactional
    public void deleteById(int id ) {
        if (id==0 ) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("user  not found");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(int id) {
        if(id==0){
            throw new IllegalArgumentException("Parameter should not be null");
        }try {
            return userRepository.findById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("User not found");

        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
