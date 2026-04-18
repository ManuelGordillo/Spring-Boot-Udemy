package com.andres.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Invoice {

  // Inyectando un Cliente
  @Autowired
  private Client client;

  @Value("${invoice.description.office}")
  private String description;

  // Inyectando una list de items
  @Autowired
  @Qualifier("default")
  private List<Item> items;

  @PostConstruct //Se ejecuta cuando se genera el componente
  public void init() {
    System.out.println("Creando el componente de la factura");
    client.setName(client.getName().concat(" Ernesto"));
    description=description.concat(" del cliente: ").concat(client.getName().concat(" ").concat(client.getLastName()));
  }

  public Client getClient() {
    return client;
  }
  public void setClient(Client client) {
    this.client = client;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public List<Item> getItems() {
    return items;
  }
  public void setItems(List<Item> items) {
    this.items = items;
  }
  
  public int getTotal() {
    // int total = 0;
    // for (Item item : items) {
    //   total += item.getImporte();
    // }
int total= items.stream()
.map(item-> item.getImporte())
    .reduce(0, (sum, importe) -> sum + importe);
    return total;
  }
  
}
