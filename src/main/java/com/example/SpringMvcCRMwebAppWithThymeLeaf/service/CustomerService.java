package com.example.SpringMvcCRMwebAppWithThymeLeaf.service;

import com.example.SpringMvcCRMwebAppWithThymeLeaf.model.Customer;
import com.example.SpringMvcCRMwebAppWithThymeLeaf.repo.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{

    private ICustomerRepo repo;
    @Autowired
    public void setRepo(ICustomerRepo repo){
        this.repo=repo;
    }
    @Override
    public List<Customer>findAllCustomers(){
       return  (List<Customer>) repo.findAll();
    }
     @Override
    public void registerCustomer(Customer customer){
         repo.save(customer);
    }

    @Override
    public Customer fetchCustomerById(Integer id) {
        Optional<Customer>optional=repo.findById(id);
        return optional.get();
    }

    @Override
    public void deleteCustomerById(Integer id) {
          repo.deleteById(id);
    }


}
