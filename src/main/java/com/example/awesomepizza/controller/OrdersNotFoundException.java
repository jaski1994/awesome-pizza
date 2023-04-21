package com.example.awesomepizza.controller;

public class OrdersNotFoundException extends RuntimeException {

    public OrdersNotFoundException(Integer id) {
      super("Could not find orders " + id);
    }
}