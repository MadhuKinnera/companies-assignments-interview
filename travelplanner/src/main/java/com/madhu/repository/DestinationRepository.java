package com.madhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhu.entity.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    
	
}
