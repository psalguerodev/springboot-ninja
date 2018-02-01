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
		this.listPerson.add(new Person("Patrick", "Salguero", 22 ));
		this.listPerson.add(new Person("Cesar", "Salguero", 24));
		this.listPerson.add(new Person("Raquel", "Avalos", 24));
	}
	
	@Override
	public List<Person> getListPeople() {
		return this.listPerson;
	}

	@Override
	public Person addPerson(Person p) {
		this.listPerson.add( p );
		return this.listPerson.get( this.listPerson.size() - 1 );
	}

	@Override
	public void deletePerson(String name) {
		// TODO Auto-generated method stub
		for( Person p : this.listPerson ) {
			if( p.getName().toUpperCase().trim().equals( name.toUpperCase().trim())) {
				this.listPerson.remove(p);
			}
		}
	}
	
	

	
}
