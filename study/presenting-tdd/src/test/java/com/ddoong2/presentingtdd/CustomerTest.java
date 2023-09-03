package com.ddoong2.presentingtdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    @Test
    void childrenMovieDaysRentedLTE3() {

        // given
        // when
        customer.addRental("childrenMove", MovieType.CHILDREN, 3);
        // then
        assertThat(customer.getFrequenceRenterPoints()).isEqualTo(1);
        assertThat(customer.getCharge()).isEqualTo(1.5);
    }
}
