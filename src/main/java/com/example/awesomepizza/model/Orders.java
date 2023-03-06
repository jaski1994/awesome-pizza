package com.example.awesomepizza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;

@Entity // This tells Hibernate to make a table out of this class
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String tag;

	private Boolean makeingPizza;

	private Boolean completed;

	private Timestamp insertDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pizza_id", referencedColumnName = "id")
	private Pizza pizza;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public boolean getMakeingPizza() {
    return makeingPizza;
  }

  public void setMakeingPizza(Boolean makeingPizza) {
    this.makeingPizza = makeingPizza;
  }

  public boolean getCompleted() {
    return completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  public Timestamp getInsertDate() {
    return insertDate;
  }

  public void setInsertDate(Timestamp insertDate) {
    this.insertDate = insertDate;
  }
  
  public Pizza getPizza() {
    return this.pizza;
  }

  public void setPizza(Pizza pizza) {
    this.pizza = pizza;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}