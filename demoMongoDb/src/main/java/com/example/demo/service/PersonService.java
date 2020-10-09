package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public Person create(String firstName,String lastName, int age)
	{		System.out.println("first "+firstName +"last "+lastName);

		return personRepository.save(new Person(firstName,lastName,age));
	}
	
	//retrive
	public List<Person> getAll()
	{
		return personRepository.findAll();
	}
	//return spec person
	public Person getByFirstName(String firstName)
	{
		return personRepository.findByFirstName(firstName);
	}
	
	//update
	public Person update(String firstName, String lastName, int age)
	{
		Person p=personRepository.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return personRepository.save(p);
	}
	
	//delete
	public void deleteAll()
	{
		personRepository.deleteAll();
		
	}
	public void delete (String firstName)
	{
		Person p=personRepository.findByFirstName(firstName);
		personRepository.delete(p);
	}
	

}
