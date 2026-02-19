package com.example.SpringMvcCRMwebAppWithThymeLeaf.web;

import com.example.SpringMvcCRMwebAppWithThymeLeaf.model.Customer;
import com.example.SpringMvcCRMwebAppWithThymeLeaf.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {
    private  ICustomerService service;
    @Autowired
    public void setService(ICustomerService service){
        this.service=service;
    }
     @GetMapping("/customerInfo")
    public String findAllCustomerInfo(Model model){
         List<Customer>list=service.findAllCustomers();
         model.addAttribute("customer",list);
         return "customerInfo";
    }

     @GetMapping("/showForm")
     public String fillForm(){
        return "showForm";
     }

     @PostMapping("/registration")
    public String registerCustomer(Customer customer,Model model){
        service.registerCustomer(customer);
        return "redirect:/customerInfo";
     }
}
