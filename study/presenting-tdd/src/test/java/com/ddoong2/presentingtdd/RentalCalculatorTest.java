package com.ddoong2.presentingtdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RentalCalculatorTest {

    private RentalCalculator rentalCalculator;

    @BeforeEach
    void setUp() {
        rentalCalculator = new RentalCalculator();
    }

    @Test
    void childrenMovieDaysRentedLTE3() {

        addRentalAndAssertPointsAndCharge("childrenMove", Movie.MovieType.CHILDREN, 3, 1, 1.5);
    }

    @Test
    void childrenMovieDaysRentedLGT3() {

        addRentalAndAssertPointsAndCharge("childrenMove", Movie.MovieType.CHILDREN, 4, 1, 3.0);
    }

    @ParameterizedTest
    @MethodSource("provideMovieAndExpectedValues")
    void addRentalForVariousCase(String title, Movie.MovieType moveType, int daysRented, int expectedPoints, double expectedCharge) {
        addRentalAndAssertPointsAndCharge(title, moveType, daysRented, expectedPoints, expectedCharge);
    }

    @Test
    void multipleRentals() {
        rentalCalculator.addRental("title", Movie.MovieType.CHILDREN, 3);
        rentalCalculator.addRental("title", Movie.MovieType.CHILDREN, 4);
        rentalCalculator.addRental("title", Movie.MovieType.REGULAR, 2);
        rentalCalculator.addRental("title", Movie.MovieType.REGULAR, 3);
        rentalCalculator.addRental("title", Movie.MovieType.NEW_RELEASE, 1);
        rentalCalculator.addRental("title", Movie.MovieType.NEW_RELEASE, 2);

        assertThat(rentalCalculator.getFrequenceRenterPoints()).isEqualTo(7);
        assertThat(rentalCalculator.getCharge()).isEqualTo(19.0);
    }

    private void addRentalAndAssertPointsAndCharge(String title, Movie.MovieType movieType, int daysRented, int expectedPoints, double expectedCharge) {
        // given
        // when
        rentalCalculator.addRental(title, movieType, daysRented);
        // then
        assertThat(rentalCalculator.getFrequenceRenterPoints()).isEqualTo(expectedPoints);
        assertThat(rentalCalculator.getCharge()).isEqualTo(expectedCharge);
    }

    public static Stream<Arguments> provideMovieAndExpectedValues() {
        return Stream.of(
                Arguments.of("childrenMovie", Movie.MovieType.CHILDREN, 3, 1, 1.5),
                Arguments.of("childrenMovie", Movie.MovieType.CHILDREN, 4, 1, 3.0),
                Arguments.of("regularMovie", Movie.MovieType.REGULAR, 2, 1, 2.0),
                Arguments.of("regularMovie", Movie.MovieType.REGULAR, 3, 1, 3.5),
                Arguments.of("newReleaseMovie", Movie.MovieType.NEW_RELEASE, 1, 1, 3.0),
                Arguments.of("newReleaseMovie", Movie.MovieType.NEW_RELEASE, 2, 2, 6.0)
        );
    }
}
