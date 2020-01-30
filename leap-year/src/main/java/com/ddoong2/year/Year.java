package com.ddoong2.year;

public class Year {
    private final int year;

    public Year(int year) {
        this.year = year;
    }

    public boolean leapYear() {
        return divisibleBy(4) &&
                !(divisibleBy(100) && notDivisibleBy(400));
    }

    private boolean notDivisibleBy(int number) {
        return this.year % number != 0;
    }

    private boolean divisibleBy(int number) {
        return this.year % number == 0;
    }
}
