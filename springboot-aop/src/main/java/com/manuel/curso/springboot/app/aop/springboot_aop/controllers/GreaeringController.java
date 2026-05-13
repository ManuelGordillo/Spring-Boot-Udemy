package com.manuel.curso.springboot.app.aop.springboot_aop.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.manuel.curso.springboot.app.aop.springboot_aop.services.GreetingServices;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class GreaeringController {

  @Autowired
  private GreetingServices greetingService;
  
  @GetMapping("/greeting")
  public ResponseEntity<?> greeting(){
    return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHello("Pepe", "Hola que tal.")));
  }
  

}
