package com.ddoong2.presentingtdd;

public abstract class Movie {
    String title;
    MovieType type;

    public Movie() {
    }

    protected Movie(String title, MovieType type) {

        this.title = title;
        this.type = type;
    }

    public static Movie of(String title, MovieType type) {
        switch (type) {
            case CHILDREN:
                return new ChildrenMovie(title, MovieType.CHILDREN);
            case REGULAR:
                return new RegualrMovie(title, MovieType.REGULAR);
            case NEW_RELEASE:
                return new NewReleaseMovie(title, MovieType.NEW_RELEASE);
            default:
                throw new IllegalArgumentException("Invalid movie type");
        }
    }

    public abstract Integer getFrequenceRenterPoints(int daysRented1);

    public abstract Double getCharge(int daysRented1);

    public enum MovieType {
        CHILDREN,
        REGULAR,
        NEW_RELEASE
    }
}