package com.springdatajpa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springdatajpa.entity.Customer;
import com.springdatajpa.entity.SalesRep;
import com.springdatajpa.service.CustomerService;
import com.springdatajpa.service.SalesRepService;
 
 
@Controller
@RequestMapping("/customer")
public class CustomerController {
 
    @Autowired
    private CustomerService customerService;
    
    @Autowired
	private SalesRepService salesRepService;
 
    @RequestMapping
    public ModelAndView home() {
        List<Customer> listCustomer = customerService.listAll();
        ModelAndView mav = new ModelAndView("customer_index");
        mav.addObject("listCustomer", listCustomer);
        
        return mav;
    }
    
    @RequestMapping("/new")
    public String newCustomerForm(Map<String, Object> model) {
        Customer customer = new Customer();
        model.put("customer", customer);
        
        return "new_customer";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        
        return "redirect:/customer";
    }
    
    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_customer");
        Customer customer = customerService.get(id);
        mav.addObject("customer", customer);
     
        return mav;
    }
    
    @RequestMapping("/assign")
    public ModelAndView assignCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("assign_customer");
        Customer customer = customerService.get(id);
        List<SalesRep> listSalesRep = salesRepService.listAll();
        mav.addObject("listSalesRep", listSalesRep);
        mav.addObject("customer", customer);
     
        return mav;
    }
    
    @RequestMapping(value="assign_rep")
    public String saveCustomerRep(@ModelAttribute("customer")Customer customer,@RequestParam long salesRepId) {
    	customerService.assignRep(customer.getId(), salesRepId);

    	return "redirect:/customer";
    }
    
    
    
    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        customerService.delete(id);
        
        return "redirect:/customer";       
    }
    
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Customer> result = customerService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
     
        return mav;    
    }
}