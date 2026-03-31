package com.manuel.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.manuel.springboot.di.app.springboot_di.models.Product;

@Component
public class ProductRepositoryImpl implements ProductoRepository{
  private List<Product> data;

  
  public ProductRepositoryImpl() {
    this.data = Arrays.asList(
        new Product(1L, "Mmoria corsair 32Gb", 300L),
        new Product(2L, "Cpu Intel Core i9", 850L),
        new Product(3L, "Teclado Rayzer mini 60%", 180L),
        new Product(4L, "Motherboard Gigabyte", 490L));
  }
  
  @Override
  public List<Product> findAll() {
    return data;
  }

  @Override
  public Product findById(Long id) {
    return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
