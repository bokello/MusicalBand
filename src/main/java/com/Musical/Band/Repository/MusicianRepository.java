package com.Musical.Band.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Musical.Band.Models.Band;
import com.Musical.Band.Models.Musician;

public interface MusicianRepository extends JpaRepository<Musician, Long> {

	@Query("select b from Band b join b.musicians m where m.id = ?1")
	List<Band> findAllBandsByMusicianId(long musicianId);
	
}
