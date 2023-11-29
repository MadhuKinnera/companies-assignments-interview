package com.madhu.service;

import com.madhu.entity.Itinerary;
import com.madhu.exceptions.ItineraryException;

public interface ItineraryService {
	
	Itinerary addToItinerary(Itinerary itinerary) throws ItineraryException;

	Itinerary updateItinerary(Long id, Itinerary itinerary) throws ItineraryException;

	void removeFromItinerary(Long id) throws ItineraryException;
}
