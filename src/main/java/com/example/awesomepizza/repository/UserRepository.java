package com.example.awesomepizza.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.awesomepizza.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
    List<User> findByName(String name);
}
