package com.madhu.service;

import java.util.List;

import com.madhu.entity.Destination;
import com.madhu.exceptions.DestinationException;

public interface DestinationService {
	
	List<Destination> getAllDestinations() throws DestinationException;

	Destination getDestinationById(Long id) throws DestinationException;

	Destination addDestination(Destination destination) throws DestinationException;

	Destination updateDestination(Long id, Destination destination) throws DestinationException;

	void deleteDestination(Long id) throws DestinationException;
}
