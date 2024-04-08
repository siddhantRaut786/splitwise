package com.example.splitwise.repositories;

import com.example.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    User findUserById(Long id);

    List<User> findUserByUsernameAndPhoneNumber(String username);
}
