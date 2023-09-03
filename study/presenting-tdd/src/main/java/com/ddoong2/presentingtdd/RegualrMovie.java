package com.ddoong2.presentingtdd;

public class RegualrMovie extends Movie {
    public RegualrMovie(String title, MovieType movieType) {
        super(title, movieType);
    }

    @Override
    public Integer getFrequenceRenterPoints(int daysRented1) {
        return 1;
    }

    @Override
    public Double getCharge(int daysRented1) {
        double charge = 2;
        if (daysRented1 > 2) {
            charge += (daysRented1 - 2) * 1.5;
        }
        return charge;
    }
}
