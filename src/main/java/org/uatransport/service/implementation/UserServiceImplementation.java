package org.uatransport.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uatransport.entity.Role;
import org.uatransport.entity.User;
import org.uatransport.entity.dto.LoginDTO;
import org.uatransport.entity.dto.UserDTO;
import org.uatransport.exception.ResourceNotFoundException;
import org.uatransport.exception.SecurityException;
import org.uatransport.repository.UserRepository;
import org.uatransport.security.JwtTokenProvider;
import org.uatransport.service.UserService;

import java.util.List;


@Service
@RequiredArgsConstructor
@Qualifier("UserDetails")
public class UserServiceImplementation implements UserService {


    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String signin(LoginDTO loginDTO) {
        String username = loginDTO.getEmail();
        String password = loginDTO.getPassword();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userRepository.findByEmail(username).getRole());
        } catch (AuthenticationException e) {
            throw new SecurityException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);

        }
    }

    public String signup(UserDTO userDTO) {

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
        return jwtTokenProvider.createToken(user.getEmail(), user.getRole());


    }

    @Override
    @Transactional
    public User addUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        User user = new User();
        user.setRole(Role.USER);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(bcryptEncoder.encode(userDTO.getPassword()));

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
