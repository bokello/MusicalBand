package com.Musical.Band.Models;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	public List<Musician> getMusicians() {
	     return musicians;
	}
	
	public void setMusicians(List<Musician> musicians) {
		this.musicians = musicians;
	}
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "person")
	@JsonIgnore 
	private List<Musician> musicians;
	
	@Override
	public boolean equals(Object o) {
	if (this == o) return true;
	if (o == null || getClass() != o.getClass()) return false;
	Person person = (Person) o;
	   return age == person.age && Objects.equals(id, person.id) ;
	}
	
	@Override
	public int hashCode() {
	 return Objects.hash(id, firstName, lastName, email, age);
	}
	
	public Long getId() {
	  return id;
	}
	
	public void setId(Long id) {
	  this.id = id;
	}
	
	public String getFirstName() {
	  return firstName;
	}
	
	public void setFirstName(String firstName) {		
		this.firstName = firstName;
	}
		
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Column
	private int age;
	
	public Person() {
	}
		
	
}
