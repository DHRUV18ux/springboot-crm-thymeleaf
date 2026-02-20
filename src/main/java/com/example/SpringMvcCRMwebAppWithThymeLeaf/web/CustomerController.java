package com.example.SpringMvcCRMwebAppWithThymeLeaf.web;

import com.example.SpringMvcCRMwebAppWithThymeLeaf.model.Customer;
import com.example.SpringMvcCRMwebAppWithThymeLeaf.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
         model.addAttribute("customers",list);
         return "customerInfo";
    }

     @GetMapping("/showForm")
     public String fillForm(Model model){
         model.addAttribute("customer", new Customer());
        return "showForm";
     }

     @PostMapping("/registration")
    public String registerCustomer(@ModelAttribute Customer customer,Model model){
        service.registerCustomer(customer);
        return "redirect:/customerInfo";
     }

     @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerID") Integer id){
             service.deleteCustomerById(id);
             return "redirect:/customerInfo";
     }
      @GetMapping("/updateCustomer")
     public String updateCustomer(@RequestParam("customerId") Integer id,Model model){
         Customer cus=service.fetchCustomerById(id);
         model.addAttribute("customer",cus);
        return "showForm";
     }
}
