package com.example.awesomepizza.controller;

public class PizzaNotFoundException extends RuntimeException {

  public PizzaNotFoundException(Integer id) {
    super("Could not find pizza " + id);
  }
}