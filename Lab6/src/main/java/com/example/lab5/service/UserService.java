package com.example.lab5.service;


import com.example.lab5.domain.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService extends GeneralService<User, Integer>{
    User findByUserName(String userName) throws Exception;

    Boolean existsByUserName(String userName);
}
