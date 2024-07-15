package com.demo.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import com.demo.model.Customer;

public interface CustomerService {
    List<Customer> findAll();
    Customer createCustomer(Customer c);
    void deleteCustomer(Long id);
    Optional<Customer> getCustomerById(Long id);
	List<Customer> getAllCustomers();
    Customer updateCustomer(Long id, Customer customer);

}
