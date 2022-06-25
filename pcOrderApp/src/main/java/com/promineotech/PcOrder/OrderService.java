package com.promineotech.PcOrder;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderService {
  @Autowired
  OrderDefaultService orderDefaultService;

  @PostMapping("/add/order")
  public String addOrder(@RequestBody Order order) {
    orderDefaultService.save(order);
    return "Success";
  }

  @GetMapping("/order/{order_id}")
  public Order getOrder(@PathVariable int order_id) {
    return orderDefaultService.findById(order_id).get();
  }

  @GetMapping("/get/orders")
  public List<Order> getOrders() {
    return orderDefaultService.findAll();
  }

  @PutMapping("/update/order")
  public String UpdateOrder(@RequestBody Order order) {
    Order st = orderDefaultService.getById(order.getId());
    st.setId(order.getId());
    st.setFirstName(order.getFirstName());
    st.setLastName(order.getLastName());
    st.setPhoneNumber(order.getPhoneNumber());
    st.setOrderNumber(order.getOrderNumber());
    orderDefaultService.save(st);
    return "Updated";
  }

  @DeleteMapping("/order/{order_id}")
  public String deleteOrder(@PathVariable int order_id) {
    orderDefaultService.deleteById(order_id);
    return "Deleted";
  }
}
