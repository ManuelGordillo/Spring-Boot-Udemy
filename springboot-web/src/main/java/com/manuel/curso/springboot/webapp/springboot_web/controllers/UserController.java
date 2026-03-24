package com.manuel.curso.springboot.webapp.springboot_web.controllers;




import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.manuel.curso.springboot.webapp.springboot_web.models.User;





@Controller
public class UserController {

  @GetMapping("/details")
  public String details(Model model) {
    User user = new User("Manuel", "Gordillo");
    model.addAttribute("title", "Hola Mundo Spring Boot");
    model.addAttribute("user", user);
    // model.addAttribute("name", "Manuel");
    // model.addAttribute("lastname", "Gordillo");
    // public String details(Map<String, Object> model) {
    //   model.put("title", "Hola Mundo Spring Boot");
    //   model.put("name", "Manuel");
    //   model.put("lastname", "Gordillo");

    return "details";
  }
  
  @GetMapping("/list")
  public String list(ModelMap model) {

    // model.addAttribute("users", users);
    model.addAttribute("title", "Listado de usuarios");
    return "list";
  }
  
  @ModelAttribute("users")
  public List<User> usersModel() {
    List<User> users = Arrays.asList(
        new User("Pepa", "Gonzales"),
        new User("Lalo ", "Perez","lalo@correo.com"),
        new User("Juanita ", "Roe"),
        new User("Manuel", "Gordillo"));
    return users;
  }
  

}
