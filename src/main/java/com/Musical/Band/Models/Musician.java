package com.Musical.Band.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MUSICIAN")
public class Musician 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "person_id")
	private Person person;
	
	@ManyToMany(mappedBy = "musicians")
	@JsonIgnore //needed to avoid infinite recursion
	private List<Band> bands = new ArrayList<>();
	
	public Musician() {
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
	    this.person = person;
	}
	
	public Long getId() {
	    return id;
	}
	public void setId(Long id) {
	   this.id = id;
	}
	

}
