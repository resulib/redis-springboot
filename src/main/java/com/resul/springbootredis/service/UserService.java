package com.resul.springbootredis.service;

import com.resul.springbootredis.entity.UserEntity;
import com.resul.springbootredis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void create(UserEntity user) {
        userRepository.save(user);
    }
}
