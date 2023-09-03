package com.ddoong2.presentingtdd;

import java.util.ArrayList;
import java.util.List;

public class RentalCalculator {
    private List<Rental> rentals = new ArrayList<>();

    public void addRental(String title, Movie.MovieType type, int daysRented) {

        rentals.add(new Rental(title, type, daysRented));
    }

    public Integer getFrequenceRenterPoints() {

        return rentals.stream()
                .mapToInt(rental -> rental.getFrequenceRenterPoints(rental.daysRented))
                .sum();
    }

    public Double getCharge() {

        return rentals.stream()
                .mapToDouble(rental -> rental.getCharge(rental.daysRented))
                .sum();
    }
}
