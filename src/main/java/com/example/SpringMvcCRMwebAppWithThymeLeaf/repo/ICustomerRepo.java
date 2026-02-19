package com.example.SpringMvcCRMwebAppWithThymeLeaf.repo;

import com.example.SpringMvcCRMwebAppWithThymeLeaf.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends CrudRepository<Customer,Integer> {

}
