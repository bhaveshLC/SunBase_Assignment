package com.demo.service;

import com.demo.dao.CustomerDao;
import com.demo.model.Customer;
import com.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao cd;

    @Override
    public List<Customer> getAllCustomers() {
        return cd.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = cd.findById(id);
        return optionalCustomer;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return cd.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer c) {
        Optional<Customer> existingCustomerOpt = cd.findById(id);
        if (existingCustomerOpt.isPresent()) {
            Customer existingCustomer = existingCustomerOpt.get();
            existingCustomer.setFirst_name(c.getFirst_name());
            existingCustomer.setLast_name(c.getLast_name());
            existingCustomer.setStreet(c.getStreet());
            existingCustomer.setAddress(c.getAddress());
            existingCustomer.setCity(c.getCity());
            existingCustomer.setState(c.getState());
            existingCustomer.setEmail(c.getEmail());
            existingCustomer.setPhone(c.getPhone());
            return cd.save(existingCustomer);
        }
        return null;
    }


    @Override
    public void deleteCustomer(Long id) {
        cd.deleteById(id);
    }

	@Override
	public List<Customer> findAll() {
		return cd.findAll();
	}
}