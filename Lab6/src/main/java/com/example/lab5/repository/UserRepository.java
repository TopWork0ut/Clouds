package com.example.lab5.repository;

import com.example.lab5.domain.Supplement;
import com.example.lab5.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>
{
    Optional<User> findByUserName(String userName);

    Boolean existsByUserName(String userName);
}
