package com.promineotech.PcOrder;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerService {
  @Autowired
  CustomerDefaultService customerDefaultService;

  @PostMapping("/add/customer")
  public String addCustomer(@RequestBody Customer customer) {
    customerDefaultService.save(customer);
    return "Success";
  }

  @GetMapping("/customer/{customer_id}")
  public Customer getCustomer(@PathVariable int customer_id) {
    return customerDefaultService.findById(customer_id).get();
  }

  @GetMapping("/customers")
  public List<Customer> getCustomers() {
    return customerDefaultService.findAll();
  }

  @PutMapping("/update/customer")
  public String UpdateCustomer(@RequestBody Customer customer) {
    Customer st = customerDefaultService.getById(customer.getId());
    st.setId(customer.getId());
    st.setFirstName(customer.getFirstName());
    st.setLastName(customer.getLastName());
    st.setPhoneNumber(customer.getPhoneNumber());
    st.setOrderNumber(customer.getOrderNumber());
    customerDefaultService.save(st);
    return "Updated";
  }

  @DeleteMapping("/delete/customer/{customer_id}")
  public String deleteCustomer(@PathVariable int customer_id) {
    customerDefaultService.deleteById(customer_id);
    return "Deleted";
  }
}
