package com.secure.rest_services.dao;

import com.secure.rest_services.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
    public List<Customer> findByEmail(String email);
}
