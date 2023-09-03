package com.ddoong2.presentingtdd;

public class MovieRepository {
    public MovieRepository() {
    }

    public static Movie findMovieBy(String title, Movie.MovieType type) {
        return Movie.of(title, type);
    }
}