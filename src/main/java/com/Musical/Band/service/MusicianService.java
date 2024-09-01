package com.Musical.Band.service;

import org.springframework.stereotype.Service;
import com.Musical.Band.Repository.MusicianRepository;
import com.Musical.Band.Repository.PersonRepository;


@Service
public class MusicianService {

	private MusicianRepository musicianRepository;	
	private PersonRepository personRepository;
	
	public MusicianService(MusicianRepository musicianRepository,PersonRepository personRepository)
	{
		this.musicianRepository = musicianRepository;
		this.personRepository = personRepository;		
	}
	
		
	
	
	
	
}
