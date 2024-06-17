package com.secure.rest_services.service;

import com.secure.rest_services.dao.CustomerDao;
import com.secure.rest_services.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
* This service is supposed to be used when DaoAuthentication provider is supposed
 * to be used. When CustomAuthenticationProvider is used. It's of no use. It can
 * be deleted if required.
*  */
@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Customer registerUser(Customer customer) throws Exception {
        try {
            String hashedPassword = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashedPassword);
            Customer savedCustomer = customerDao.save(customer);
            return savedCustomer;
        }catch (Exception ex){
            throw new Exception("Error registering customer");
        }
    }
}
