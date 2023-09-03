package com.codurance;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

    public static final DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String todayAsString() {
        return today().format(DD_MM_YYYY);
    }

    protected LocalDate today() {
        return LocalDate.now();
    }
}
