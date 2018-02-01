package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.model.Person;

public interface ExampleService {
	
	public abstract List<Person> getListPeople();
	
	public abstract Person addPerson(Person p);
	
	public abstract void deletePerson( String name );
}
