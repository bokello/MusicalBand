package com.Musical.Band.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Musical.Band.Models.Person;


public interface PersonRepository extends JpaRepository<Person, Long>{

}
