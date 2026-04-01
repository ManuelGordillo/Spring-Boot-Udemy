package com.manuel.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.context.annotation.Primary;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.manuel.springboot.di.app.springboot_di.models.Product;
// import com.manuel.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;
import com.manuel.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

  // @Autowired
  // private ProductRepositoryImpl repository = new ProductRepositoryImpl();
  // private ProductRepositoryImpl repository; Inyectando con el @Component
  private ProductRepository repository; // Inyectando por la Interface
  // @Autowired
  // public void setRepository(ProductoRepository repository) {
  //   this.repository = repository;
  // } implementacion con setter



  public ProductServiceImpl(@Qualifier("productFoo") ProductRepository repository) {
    this.repository = repository;
  } // inyectando la implementacion con el econstructor

  @Override
  public List<Product> findAll() {
    return repository.findAll().stream().map(p -> {
      Double priceTax = p.getPrice() * 1.25d;
      // Product newProd = new Product(p.getId(),p.getName(), priceTax.longValue());
      Product newProd = (Product) p.clone();
      newProd.setPrice(priceTax.longValue());
      return newProd;
    }).collect(Collectors.toList());
  }


  @Override
  public Product findById(Long id) {
    return repository.findById(id);
  }

}
