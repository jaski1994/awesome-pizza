package com.example.awesomepizza.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.awesomepizza.model.Orders;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface OrdersRepository extends CrudRepository<Orders, Integer> {


    List<Orders> findByTag(String tag);
    List<Orders> findByCompleted(Boolean completed);
    List<Orders> findByMakeingPizza(Boolean makeingPizza);
    List<Orders> findByMakeingPizzaAndCompleted(Boolean makeingPizza,Boolean completed);
    List<Orders> findByOrderByInsertDateAsc();

    
}