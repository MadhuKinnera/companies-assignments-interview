package com.madhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhu.entity.Itinerary;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

}
