package com.secure.rest_services.service;

import com.secure.rest_services.dao.CustomerDao;
import com.secure.rest_services.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    public Customer registerUser(Customer customer) throws Exception {
        try {
            Customer savedCustomer = customerDao.save(customer);
            return savedCustomer;
        }catch (Exception ex){
            throw new Exception("Error registering customer");
        }
    }
}
