package com.springdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdatajpa.entity.Customer;
import com.springdatajpa.entity.SalesRep;
import com.springdatajpa.repository.CustomerRepository;
import com.springdatajpa.repository.SalesRepRepository;
 
@Service
//@Transactional DONT NEED ON CLASS- can just add to methods that need the transaction manager
public class CustomerService {
    @Autowired CustomerRepository repo;
    @Autowired SalesRepRepository salesRepRepo;
    
     
    
    //ADD/UPDATE BY PK. Creates a transaction, doesnt need the @Transactional
    public void save(Customer customer) {
        repo.save(customer);
    }
     
    public List<Customer> listAll() {
        return (List<Customer>) repo.findAll();
    }
     
    public Customer get(Long id) {
        return repo.findById(id).get();
    }
    
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
    public List<Customer> search(String keyword) {
        return repo.search(keyword);
    }
    
    @Transactional
    public void assignRep(Long customerId,Long salesRepId)
    {
    	SalesRep salesRep = salesRepRepo.findById(salesRepId).get();
    	repo.findById(customerId).get().setSalesRep(salesRep);
   
    }
    
    
     
}