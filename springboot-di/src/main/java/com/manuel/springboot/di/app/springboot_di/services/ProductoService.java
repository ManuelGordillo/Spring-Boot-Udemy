package com.manuel.springboot.di.app.springboot_di.services;

import java.util.List;

import com.manuel.springboot.di.app.springboot_di.models.Product;

public interface ProductoService {
  List<Product> findAll();

  Product findById(Long id);

}
