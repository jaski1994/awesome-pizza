package com.example.awesomepizza.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Date;
import java.util.Collection;
import java.util.stream.Collectors;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.apache.commons.lang.RandomStringUtils;

import com.example.awesomepizza.model.Orders;
import com.example.awesomepizza.model.Pizza;
import com.example.awesomepizza.model.User;
import com.example.awesomepizza.repository.*;

@RestController // This means that this class is a Controller
@RequestMapping(path="/api/v1") // This means URL's start with /demo (after Application path)
public class MainController implements ErrorController{
  // This means to get the bean called userRepository
  // Which is auto-generated by Spring, we will use it to handle the data
  @Autowired        
  private OrdersRepository orderRepository;
  @Autowired 
  private PizzaRepository pizzaRepository;
  @Autowired 
  private UserRepository userRepository;
  private static final String PATH = "/error";


  //
  // pizza
  //
	@GetMapping("/pizza")
	public Iterable<Pizza> allPizza() {
		return pizzaRepository.findAll();
	}

	@PostMapping(path="/pizza") // Map ONLY POST Requests
	public @ResponseBody String addNewPizza (@RequestParam String name, @RequestParam String descrizione) {

		Pizza n = new Pizza();
		n.setName(name);
		n.setDescrizione(descrizione);
		pizzaRepository.save(n);
		return "Saved";
	}

  //
	// Single pizza
  //
	@GetMapping("/pizza/{id}")
	public Pizza onePizza(@PathVariable Integer id) {

		return pizzaRepository.findById(id)
		  .orElseThrow(() -> new PizzaNotFoundException(id));
	}

	@PutMapping("/pizza/{id}")
	public Pizza replacePizza(@RequestBody Pizza newPizza, @PathVariable Integer id) {

		return pizzaRepository.findById(id)
		  .map(pizz -> {
        pizz.setName(newPizza.getName());
        pizz.setDescrizione(newPizza.getDescrizione());
			  return pizzaRepository.save(pizz);
		  })
		  .orElseGet(() -> {
        newPizza.setId(id);
			return pizzaRepository.save(newPizza);
		  });
	}

	@DeleteMapping("/pizza/{id}")
	public String deletePizza(@PathVariable Integer id) {
		pizzaRepository.deleteById(id);
    return "deleted";
	}
  

  //
  // user
  //
	@GetMapping("/users")
	public Iterable<User> allUser() {
		return userRepository.findAll();
	}
  
  @PostMapping(path="/users") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    n.setNotification(false);
    userRepository.save(n);
    return "Saved";
  }

  //
	// Single user
  //
	@GetMapping("/users/{id}")
	public User oneUser(@PathVariable Integer id) {

		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@PutMapping("/users/{id}")
	public User replaceUser(@RequestBody User newUser, @PathVariable Integer id) {

		return userRepository.findById(id)
		  .map(users -> {
        users.setName(newUser.getName());
        users.setEmail(newUser.getEmail());
			  return userRepository.save(users);
		  })
		  .orElseGet(() -> {
        newUser.setId(id);
			return userRepository.save(newUser);
		  });
	}

	@DeleteMapping("/users/{id}")
	public @ResponseBody String deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
    return "deleted";
	}


  @GetMapping(path="/users/{id}/notification") 
  public @ResponseBody String removeNotification (@PathVariable Integer id) {

    User userNotif = userRepository.findById(id).get();
    userNotif.setNotification(false);
    userRepository.save(userNotif);
    return "notification disable";
  }

  //
	// Order
  //
  
  @GetMapping(path="/orders")
  public @ResponseBody Iterable<Orders> getAllOrders() {
    return orderRepository.findAll();
  }


  @PostMapping(path="/orders") // Map ONLY POST Requests
  public @ResponseBody String addNewOrder (@RequestParam String name, @RequestParam String user) {
	
    String tokenTag = Utils.getAlphaNumericString(5);// fx-lat
    Date datenow = new Date();

    Orders n = new Orders();
    n.setTag(tokenTag);
    n.setPizza(pizzaRepository.findByName(name).get(0));
    n.setUser(userRepository.findByName(user).get(0));
    n.setInsertDate(new Timestamp(datenow.getTime()));
    n.setCompleted(false);
    n.setMakeingPizza(false);
    orderRepository.save(n);
    return tokenTag;
  }


  //
	// Single orders
  //
	@GetMapping("/orders/{id}")
	public Orders oneOrder(@PathVariable Integer id) {

		return orderRepository.findById(id)
		  .orElseThrow(() -> new OrdersNotFoundException(id));
	}


	@DeleteMapping("/orders/{id}")
  public @ResponseBody String deleteOrders(@PathVariable Integer id) {
		orderRepository.deleteById(id);
    return "deleted";
	}

  @PatchMapping(path="/orders/{id}/make") 
  public @ResponseBody String makePizza (@PathVariable Integer id) {

    Orders x = orderRepository.findById(id).get();
    x.setMakeingPizza(true);
    orderRepository.save(x);
    
    return "make";
  }
  
  @PatchMapping(path="/orders/{id}/complete") 
  public @ResponseBody String orderCompleted (@PathVariable Integer id) {

    Orders x = orderRepository.findById(id).get();
    x.setCompleted(true);
    User userNotif = x.getUser();
    orderRepository.save(x);
    
    userNotif.setNotification(true);
    userRepository.save(userNotif);

    return "complete";
  }

}