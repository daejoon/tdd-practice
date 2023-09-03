package com.ddoong2.presentingtdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    @Test
    void childrenMovieDaysRentedLTE3() {

        addRentalAndAssertPointsAndCharge("childrenMove", MovieType.CHILDREN, 3, 1, 1.5);
    }

    @Test
    void childrenMovieDaysRentedLGT3() {

        addRentalAndAssertPointsAndCharge("childrenMove", MovieType.CHILDREN, 4, 1, 3.0);
    }

    @ParameterizedTest
    @MethodSource("provideMovieAndExpectedValues")
    void addRentalForVariousCase(String title, MovieType moveType, int daysRented, int expectedPoints, double expectedCharge) {
        addRentalAndAssertPointsAndCharge(title, moveType, daysRented, expectedPoints, expectedCharge);
    }

    public static Stream<Arguments> provideMovieAndExpectedValues() {
        return Stream.of(
                Arguments.of("childrenMovie", MovieType.CHILDREN, 3, 1, 1.5),
                Arguments.of("childrenMovie", MovieType.CHILDREN, 4, 1, 3.0)
        );
    }


    private void addRentalAndAssertPointsAndCharge(String title, MovieType movieType, int daysRented, int expectedPoints, double expectedCharge) {
        // given
        // when
        customer.addRental(title, movieType, daysRented);
        // then
        assertThat(customer.getFrequenceRenterPoints()).isEqualTo(expectedPoints);
        assertThat(customer.getCharge()).isEqualTo(expectedCharge);
    }
}
