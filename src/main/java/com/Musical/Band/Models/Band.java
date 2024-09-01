package com.Musical.Band.Models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "BAND")
public class Band {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "band_name")
	private String bandName;
	
	public Band(String bandName) {
		this.bandName = bandName;
	}
	
	public Band() 
	{
		
	}
	
	public List<Musician> getMusicians() {
		return musicians;
	}
	
	public void setMusicians(List<Musician> musicians) {
		this.musicians = musicians;
	}
	
	@ManyToMany
	@JoinTable(
	 name = "BAND_MUSICIAN",
	 joinColumns = @JoinColumn(name = "band_id"),
	 inverseJoinColumns = @JoinColumn(name = "musician_id")
	)
	
	private List<Musician> musicians = new ArrayList<>();
		
	public Long getId() {
		return id;
	}
		
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBandName() {
		return bandName;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Band band = (Band) o;
	    return Objects.equals(id, band.id) && Objects.equals(bandName, band.bandName);
	}
	
	@Override
	public int hashCode() {
	  return Objects.hash(id, bandName);
	}
	
	public void setBandName(String bandName) {
	  this.bandName = bandName;
	}
	

}
