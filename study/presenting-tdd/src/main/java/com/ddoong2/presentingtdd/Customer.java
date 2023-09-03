package com.ddoong2.presentingtdd;

public class Customer {
    private MovieType type;
    private int daysRented;

    public void addRental(String title, MovieType type, int daysRented) {
        this.type = type;

        this.daysRented = daysRented;
    }

    public Integer getFrequenceRenterPoints() {
        if (type == MovieType.NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }

    public Double getCharge() {
        double charge = 0;
        if (type == MovieType.CHILDREN) {
            charge = 1.5;
            if (daysRented > 3) {
                charge += (daysRented -3) * 1.5;
            }
        } else if (type == MovieType.REGULAR) {
            charge = 2;
            if (daysRented > 2) {
                charge += (daysRented -2) * 1.5;
            }
        } else if (type == MovieType.NEW_RELEASE) {
            charge = daysRented * 3;
        }
         return charge;
    }
}
