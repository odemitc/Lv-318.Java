package org.uaTransport.service.implementation;

import org.uaTransport.entity.User;
import org.uaTransport.exception.ResourceNotFoundException;
import org.uaTransport.repository.UserRepository;
import org.uaTransport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {


    private final UserRepository userRepository;

    @Override
    @Transactional
    public User addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public User update(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getByEmailAndPassword(String email, String password) {

        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(int id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(String
                .format("User with id '%s' not found", id)));

    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
