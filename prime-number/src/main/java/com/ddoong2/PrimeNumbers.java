package com.ddoong2;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

    private int num;

    public int[] process(int num) {
        this.num = num;
        checkValidation();
        return getPrimeNumberList()
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void checkValidation() {
        if (this.num <= 1) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> getPrimeNumberList() {
        List<Integer> numbers = new ArrayList<>();
        for (int index = 2; index <= this.num; index++) {
            if (isPrimeNumber(index)) {
                numbers.add(index);
            }
        }
        return numbers;
    }

    private boolean isPrimeNumber(int number) {
        int divideCount = 0;
        for (int iNum = 1; iNum <= number; iNum++) {
            if (number % iNum == 0) {
                divideCount++;
            }
        }
        return divideCount == 2;
    }
}
