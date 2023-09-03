package com.codurance;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ClockShould {

    @Test
    public void return_todays_date_in_dd_MM_yyyy_format() {
        Clock clock = new TestableClock();

        String date = clock.todayAsString();

        assertThat(date, is("24/04/2015"));
    }

    private static class TestableClock extends Clock {

        @Override
        protected LocalDate today() {
            return LocalDate.of(2015, 4, 24);
        }
    }
}