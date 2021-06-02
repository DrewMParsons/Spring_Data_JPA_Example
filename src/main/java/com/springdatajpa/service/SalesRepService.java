package com.springdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdatajpa.entity.SalesRep;
import com.springdatajpa.repository.SalesRepRepository;


@Service
@RequestMapping("/salesRep")
public class SalesRepService
{
	@Autowired SalesRepRepository repo;
	
	public void save(SalesRep salesRep) {
        repo.save(salesRep);
    }
     
    public List<SalesRep> listAll() {
        return (List<SalesRep>) repo.findAll();
    }
     
    public SalesRep get(Long id) {
        return repo.findById(id).get();
    }
    
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
