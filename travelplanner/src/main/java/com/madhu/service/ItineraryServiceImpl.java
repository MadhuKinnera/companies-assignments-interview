package com.madhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhu.entity.Itinerary;
import com.madhu.exceptions.ItineraryException;
import com.madhu.repository.ItineraryRepository;

@Service
public class ItineraryServiceImpl implements ItineraryService {

	@Autowired
	private ItineraryRepository itineraryRepository;

	@Override
	public Itinerary addToItinerary(Itinerary itinerary) {
		return itineraryRepository.save(itinerary);
	}

	@Override
	public Itinerary updateItinerary(Long id, Itinerary itinerary) throws ItineraryException {
		Itinerary existingItinerary = itineraryRepository.findById(id)
				.orElseThrow(() -> new ItineraryException("Itinerary not found with id: " + id));
		existingItinerary.setDestinationId(itinerary.getDestinationId());
		existingItinerary.setActivity(itinerary.getActivity());
		return itineraryRepository.save(existingItinerary);
	}

	@Override
	public void removeFromItinerary(Long id) {

		itineraryRepository.deleteById(id);
	}
}
