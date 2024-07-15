package com.demo.dao;

import org.springframework.stereotype.Repository;
import com.demo.model.Customer;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
    
    List<Customer> findAll();
    
    Optional<Customer> findById(Long id);
    
    void deleteById(Long id);

    @Modifying
    @Query(value = "UPDATE Customer c SET c.name = :customer.name, c.email = :customer.email, c.phone = :customer.phone WHERE c.id = :id", nativeQuery = true)
    void updateCustomer(@Param("id") Long id, @Param("customer") Customer customer);
}