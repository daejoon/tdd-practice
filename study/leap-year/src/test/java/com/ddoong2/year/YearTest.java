package com.ddoong2.year;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class YearTest {

    @Test
    public void 윤년이_아니라면_4로_나누어지지_않는다() {

        assertThat(leapYear(1997)).isEqualTo(false);
    }

    @Test
    public void 윤년이라면_4로_나누어진다() {

        assertThat(leapYear(1996)).isEqualTo(true);
    }

    @Test
    public void 윤년이라면_400으로_나누어진다() {
        assertThat(leapYear(1600)).isEqualTo(true);
    }

    @Test
    public void 윤년이_아니라면_100으로는_나누어지지만_400으로는_나누어지지_않는다() {
        assertThat(leapYear(1800)).isEqualTo(false);
    }

    private boolean leapYear(int intYear) {
        return new Year(intYear).leapYear();
    }
}