package com.madhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhu.entity.Destination;
import com.madhu.exceptions.DestinationException;
import com.madhu.repository.DestinationRepository;

@Service
public class DestinationServiceImpl implements DestinationService {

	@Autowired
	private DestinationRepository destinationRepository;

	@Override
	public List<Destination> getAllDestinations() {
		return destinationRepository.findAll();
	}

	@Override
	public Destination getDestinationById(Long id) throws DestinationException {
		return destinationRepository.findById(id)
				.orElseThrow(() -> new DestinationException("Destination not found with id: " + id));
	}

	@Override
	public Destination addDestination(Destination destination) {
		return destinationRepository.save(destination);
	}

	@Override
	public Destination updateDestination(Long id, Destination destination) throws DestinationException {
		Destination existingDestination = getDestinationById(id);

		existingDestination.setName(destination.getName());
		existingDestination.setDescription(destination.getDescription());
		existingDestination.setLocation(destination.getLocation());
		return destinationRepository.save(existingDestination);
	}

	@Override
	public void deleteDestination(Long id) throws DestinationException {

		var destination = getDestinationById(id);
		destinationRepository.delete(destination);
	}

}