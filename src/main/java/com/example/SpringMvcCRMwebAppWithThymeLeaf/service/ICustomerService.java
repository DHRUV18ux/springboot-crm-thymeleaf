package com.example.SpringMvcCRMwebAppWithThymeLeaf.service;

import com.example.SpringMvcCRMwebAppWithThymeLeaf.model.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> findAllCustomers();
    public void registerCustomer(Customer customer);
}
