package com.manuel.curso.springboot.webapp.springboot_web.controllers;




// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manuel.curso.springboot.webapp.springboot_web.models.User;
import com.manuel.curso.springboot.webapp.springboot_web.models.DTO.UserDTO;





@RestController
@RequestMapping("/api") //Ruta Base
public class UserRestController {

  @GetMapping("/details")
  public UserDTO details() {
    UserDTO userDTO = new UserDTO();
    User user = new User("Manuel", "Gordillo");
    userDTO.setUser(user);
    userDTO.setTitle("Hola Mundo Spring Boot");

    return userDTO;
  }
  
  @GetMapping("/list")  
    public List<User> list() {
      User user = new User("Manuel", "Gordillo");
      User user2 = new User("Pepe", "Mayorga");
      User user3 = new User("Jhon", "Lopez");
      
      List<User> users = Arrays.asList(user, user2, user3);
      // List<User> users = new ArrayList<>();
      // users.add(user);
      // users.add(user2);
      // users.add(user3);
      
      return users;
    }
  

  @GetMapping("/details-map")
  public Map<String,Object> detailsMap() {
    User user = new User("Manuel", "Gordillo");
    Map<String, Object> body = new HashMap<>();
      body.put("title", "Hola Mundo Spring Boot");
      body.put("user",user);
    return body;
  }

}
