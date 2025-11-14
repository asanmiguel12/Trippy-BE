package org.example.trips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    
    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }

    public Trip updateTrip(Long id, Trip tripDetails) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id: " + id));
        
        trip.setName(tripDetails.getName());
        trip.setDescription(tripDetails.getDescription());
        trip.setStartDate(tripDetails.getStartDate());
        trip.setEndDate(tripDetails.getEndDate());
        trip.setLocation(tripDetails.getLocation());
        trip.setBudget(tripDetails.getBudget());
        trip.setActivities(tripDetails.getActivities());
        trip.setAccommodations(tripDetails.getAccommodations());
        trip.setTransportation(tripDetails.getTransportation());
        trip.setFood(tripDetails.getFood());
        trip.setThingsToDo(tripDetails.getThingsToDo());
        trip.setNotes(tripDetails.getNotes());
        trip.setPhotos(tripDetails.getPhotos());
        trip.setVideos(tripDetails.getVideos());
        trip.setDocuments(tripDetails.getDocuments());
        trip.setLinks(tripDetails.getLinks());
        trip.setTags(tripDetails.getTags());
        trip.setCategories(tripDetails.getCategories());
        trip.setKeywords(tripDetails.getKeywords());
        
        return tripRepository.save(trip);
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }
}

