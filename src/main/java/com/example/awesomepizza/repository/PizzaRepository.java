package com.example.awesomepizza.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.awesomepizza.model.Pizza;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PizzaRepository extends CrudRepository<Pizza, Integer> {


    List<Pizza> findByName(String name);
}