package com.springdatajpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SalesRep
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String name;
    private Integer officeCode;
	
    public SalesRep()
	{
		super();
	}

	public SalesRep(Long id, String name, Integer officeCode)
	{
		super();
		this.id = id;
		this.name = name;
		this.officeCode = officeCode;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getOfficeCode()
	{
		return officeCode;
	}

	public void setOfficeCode(Integer officeCode)
	{
		this.officeCode = officeCode;
	}
    
    
    

}
