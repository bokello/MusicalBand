package com.Musical.Band.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.Musical.Band.Models.Band;
import com.Musical.Band.Models.BandCreationRequest;
import com.Musical.Band.Repository.BandRepository;
import com.Musical.Band.Repository.MusicianRepository;

import jakarta.transaction.Transactional;

@Service
public class BandService 
{
	
	private final BandRepository bandRepository;
	
	private final MusicianRepository musicianRepository;
		
	public BandService(BandRepository bandRepository, MusicianRepository musicianRepository)
	{
		this.bandRepository = bandRepository;
		this.musicianRepository = musicianRepository;
	}

	public boolean isHealthy()
	{		
		return bandRepository.count() > 0;
	}
	
	public Band createBand(BandCreationRequest bandCreationRequest) 
	{
		return bandRepository.save(new Band(bandCreationRequest.bandName()));
	}
	
	public Optional<Band> getBand(final long id) {
		return bandRepository.findById(id);
	}
	
	@Transactional
	public Optional<Band> addMusiciansToBand(long bandId, List<Long> musicianIds)
	{
		 return bandRepository.findById(bandId)
	                .map(band -> {
	                    band.setMusicians(musicianRepository.findAllById(musicianIds));
	                    return bandRepository.save(band);
	                });
		
	}
				
}
