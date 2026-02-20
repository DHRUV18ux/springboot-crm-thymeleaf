package com.example.SpringMvcCRMwebAppWithThymeLeaf.service;

import com.example.SpringMvcCRMwebAppWithThymeLeaf.model.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> findAllCustomers();
    public void registerCustomer(Customer customer);
    public Customer fetchCustomerById(Integer id);
    public void deleteCustomerById(Integer id);
}
