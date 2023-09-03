package com.ddoong2.presentingtdd;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title, MovieType movieType) {
        super(title, movieType);
    }

    @Override
    public Integer getFrequenceRenterPoints(int daysRented1) {
        return 1;
    }

    @Override
    public Double getCharge(int daysRented1) {
        double charge = 1.5;
        if (daysRented1 > 3) {
            charge += (daysRented1 - 3) * 1.5;
        }
        return charge;
    }
}
