package com.example.awesomepizza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Set;

//import org.hibernate.mapping.Set;

import jakarta.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Pizza {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name = "name")
  private String name;

  private String descrizione;

  /*@OneToMany(mappedBy = "pizza")
  Set<Order> orders;*/

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
}