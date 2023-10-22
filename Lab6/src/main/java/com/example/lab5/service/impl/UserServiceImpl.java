package com.example.lab5.service.impl;

import com.example.lab5.domain.User;
import com.example.lab5.repository.UserRepository;
import com.example.lab5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {

        return null;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public User create(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void update(Integer integer, User entity) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public User findByUserName(String userName) throws Exception {
        return userRepository.findByUserName(userName)
                .orElseThrow(()->new Exception(String.format("User [%s] was not found!", userName)));
    }

    @Override
    public Boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }
}
