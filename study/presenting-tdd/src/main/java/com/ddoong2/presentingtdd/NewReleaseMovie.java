package com.ddoong2.presentingtdd;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title, MovieType movieType) {
        super(title, movieType);
    }

    @Override
    public Integer getFrequenceRenterPoints(int daysRented1) {
        return daysRented1 > 1 ? 2 : 1;
    }

    @Override
    public Double getCharge(int daysRented1) {
        return (double) (daysRented1 * 3);
    }
}
