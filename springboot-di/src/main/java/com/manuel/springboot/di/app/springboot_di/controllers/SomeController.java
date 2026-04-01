package com.manuel.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.manuel.springboot.di.app.springboot_di.models.Product;
// import com.manuel.springboot.di.app.springboot_di.services.ProductServiceImpl;
import com.manuel.springboot.di.app.springboot_di.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;





@RestController
@RequestMapping("/api")
public class SomeController {

  @Autowired
  // private ProductServiceImpl service; inyeccion por el @Component
  private ProductService service; //inyectando mediante la interface
  // private ProductServiceImpl service = new ProductServiceImpl(); sin Autowired


  @GetMapping
  public List<Product> list() {
    return service.findAll();
  }
  
  @GetMapping("/{id}")
  public Product show(@PathVariable Long id) {
    return service.findById(id);
  }
  
}
