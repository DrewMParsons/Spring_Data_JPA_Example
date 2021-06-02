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

import com.springdatajpa.entity.SalesRep;
import com.springdatajpa.service.SalesRepService;

@Controller
@RequestMapping("/salesrep")
public class SalesRepController
{
	@Autowired
	private SalesRepService salesRepService;
	
	@RequestMapping(value={"/",""})
    public ModelAndView home() {
        List<SalesRep> listSalesRep = salesRepService.listAll();
        ModelAndView mav = new ModelAndView("salesrep_index");
        mav.addObject("listSalesRep", listSalesRep);
        
        return mav;
    }
	
	@RequestMapping("/new")
    public String newSalesRepForm(Map<String, Object> model) {
        SalesRep salesRep = new SalesRep();
        model.put("salesRep", salesRep);
        
        return "new_salesrep";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSalesRep(@ModelAttribute("salesRep") SalesRep salesRep) {
		salesRepService.save(salesRep);
        
        return "redirect:/salesrep";
    }
	
	@RequestMapping("/edit")
    public ModelAndView editSalesRep(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_salesrep");
        SalesRep salesRep = salesRepService.get(id);
        mav.addObject("salesRep", salesRep);
     
        return mav;
    }
    
    @RequestMapping("/delete")
    public String deleteSalesRepForm(@RequestParam long id) {
    	salesRepService.delete(id);
        
        return "redirect:/salesrep";       
    }
    
	

}
