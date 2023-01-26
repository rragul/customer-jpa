package com.ragul.customerjpa.controller;

import com.ragul.customerjpa.entity.Customer;
import com.ragul.customerjpa.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("get")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("get/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping("get-by-name/{name}")
    public List<Customer> getCustomersByName(@PathVariable String name){
        return customerService.getCustomersByName(name);
    }

    @PutMapping("update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("remove/{id}")
    public String deleteCustomer(@PathVariable Long id){
        return customerService.removeCustomer(id);
    }
}
