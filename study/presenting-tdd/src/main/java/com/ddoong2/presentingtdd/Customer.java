package com.ddoong2.presentingtdd;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Rental> rentals = new ArrayList<>();

    public void addRental(String title, MovieType type, int daysRented) {

        rentals.add(new Rental(title, type, daysRented));
    }

    public Integer getFrequenceRenterPoints() {

        return rentals.stream()
                .mapToInt(Rental::getFrequenceRenterPoints)
                .sum();
    }

    public Double getCharge() {

        return rentals.stream()
                .mapToDouble(Rental::getCharge)
                .sum();
    }
}
