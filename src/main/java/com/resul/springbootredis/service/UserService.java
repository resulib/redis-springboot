package com.resul.springbootredis.service;

import com.resul.springbootredis.entity.UserEntity;
import com.resul.springbootredis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Cacheable(value = "users")
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Cacheable(value = "user", key = "#id")
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow( () -> new RuntimeException("Could not find user with id: " + id) );
    }

    @CacheEvict(value = "users", allEntries = true)
    public void create(UserEntity user) {
        userRepository.save(user);
    }
}
