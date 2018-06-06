package org.uaTransport.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.uaTransport.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);

}
