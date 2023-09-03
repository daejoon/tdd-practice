package com.ddoong2.presentingtdd;

public class Rental {
    Movie movie;
    int daysRented;

    public Rental() {
    }

    public Rental(String title, Movie.MovieType type, int daysRented) {

        this.movie = MovieRepository.findMovieBy(title, type);
        this.daysRented = daysRented;
    }

    public Integer getFrequenceRenterPoints(int daysRented1) {
        return movie.getFrequenceRenterPoints(daysRented1);
    }

    public Double getCharge(int daysRented1) {
        return movie.getCharge(daysRented1);
    }
}