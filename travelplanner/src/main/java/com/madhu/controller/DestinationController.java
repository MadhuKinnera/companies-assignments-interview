package com.madhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.entity.Destination;
import com.madhu.exceptions.DestinationException;
import com.madhu.service.DestinationService;

@RestController
@RequestMapping("/destinations")
public class DestinationController {

	@Autowired
	private DestinationService destinationService;

	@GetMapping("/getDestinations")
	public List<Destination> getAllDestinations() throws DestinationException {
		return destinationService.getAllDestinations();
	}

	@PostMapping("/addDestination")
	public Destination addDestination(@RequestBody Destination destination) throws DestinationException {
		return destinationService.addDestination(destination);
	}

	@GetMapping("/getDestinationById/{id}")
	public Destination getDestinationById(@PathVariable Long id) throws DestinationException {
		return destinationService.getDestinationById(id);
	}

	@PutMapping("/updateDestinationById/{id}")
	public Destination updateDestination(@PathVariable Long id, @RequestBody Destination destination)
			throws DestinationException {
		return destinationService.updateDestination(id, destination);
	}

	@DeleteMapping("/deleteDestinationById/{id}")
	public void deleteDestination(@PathVariable Long id) throws DestinationException {
		destinationService.deleteDestination(id);
	}
}
