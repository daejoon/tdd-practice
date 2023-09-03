package com.ddoong2.presentingtdd;

public class Customer {
    private int daysRented;

    public void addRental(String title, MovieType movieType, int daysRented) {

        this.daysRented = daysRented;
    }

    public Integer getFrequenceRenterPoints() {

        return 1;
    }

    public Double getCharge() {
        double charge = 1.5;
        if (daysRented > 3) {
            charge += (daysRented - 3) * 1.5;
        }
        return charge;
    }
}
