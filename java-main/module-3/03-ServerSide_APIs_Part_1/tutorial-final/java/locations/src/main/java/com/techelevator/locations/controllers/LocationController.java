package com.techelevator.locations.controllers;

import com.techelevator.locations.models.Location;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class LocationController {

    private List<Location> locations = new ArrayList<>();

    public LocationController() {
        locations.add(new Location(1,
                "Tech Elevator Cleveland",
                "7100 Euclid Ave #14",
                "Cleveland",
                "OH",
                "44103"));
        locations.add(new Location(2,
                "Tech Elevator Columbus",
                "1275 Kinnear Rd #121",
                "Columbus",
                "OH",
                "43212"));
        locations.add(new Location(3,
                "Tech Elevator Cincinnati",
                "1776 Mentor Ave Suite 355",
                "Cincinnati",
                "OH",
                "45212"));
        locations.add(new Location(4,
                "Tech Elevator Pittsburgh",
                "901 Pennsylvania Ave #3",
                "Pittsburgh",
                "PA",
                "15233"));
        locations.add(new Location(5,
                "Tech Elevator Detroit",
                "440 Burroughs St #316",
                "Detroit",
                "MI",
                "48202"));
        locations.add(new Location(6,
                "Tech Elevator Philadelphia",
                "30 S 17th St",
                "Philadelphia",
                "PA",
                "19103"));
    }

    @RequestMapping( path = "/locations", method = RequestMethod.GET )
    public List<Location> list() {
        return locations;
    }

    @RequestMapping( value = "/locations", method = RequestMethod.POST)
    public Location add(@RequestBody Location location) {
        if( location != null ) {
            locations.add(location);
            return location;
        }
        return null;
    }

    @RequestMapping( path = "/locations/random", method = RequestMethod.GET )
    public Location random() {
        return locations.get(new Random().nextInt(locations.size()));
    }

}
