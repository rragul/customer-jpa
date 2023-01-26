package com.ragul.customerjpa.service;

import com.ragul.customerjpa.entity.Customer;
import com.ragul.customerjpa.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getCustomersByName(String name) {
        return customerRepository.findByName(name);
    }
    public String removeCustomer(Long id){
        customerRepository.deleteById(id);
        return "Customer Removed";
    }

    public Customer updateCustomer(Customer customer){
        Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setAge(customer.getAge());
        return customerRepository.save(existingCustomer);
    }


}
