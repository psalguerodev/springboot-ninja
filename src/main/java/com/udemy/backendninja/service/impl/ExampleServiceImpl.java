package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{
	
	private ArrayList<Person> listPerson;
	
	public ExampleServiceImpl() {
		this.listPerson = new ArrayList<>(1);
	}
	
	@Override
	public List<Person> getListPeople() {
		this.listPerson.add(new Person("Patrick", "Salguero", 22 ));
		this.listPerson.add(new Person("Cesar", "Salguero", 24));
		this.listPerson.add(new Person("Raquel", "Avalos", 24));
		return this.listPerson;
	}

	
}
