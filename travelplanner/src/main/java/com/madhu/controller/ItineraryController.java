package com.madhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.entity.Itinerary;
import com.madhu.exceptions.ItineraryException;
import com.madhu.service.ItineraryService;

@RestController
@RequestMapping("/itineraries")
public class ItineraryController {

    @Autowired
    private ItineraryService itineraryService;

    @PostMapping("/addItinerary")
    public Itinerary addToItinerary(@RequestBody Itinerary itinerary) throws ItineraryException {
        return itineraryService.addToItinerary(itinerary);
    }

    @PutMapping("/updateItinerary/{id}")
    public Itinerary updateItinerary(@PathVariable Long id, @RequestBody Itinerary itinerary) throws ItineraryException {
        return itineraryService.updateItinerary(id, itinerary);
    }

    @DeleteMapping("/deleteItinerary/{id}")
    public void removeFromItinerary(@PathVariable Long id) throws ItineraryException {
        itineraryService.removeFromItinerary(id);
    }
}
