package com.ddoong2;

public class CloserToZero {

    public int find(int[] data) {
        checkValidation(data);

        int result = data[0];
        for (int index = 1; index < data.length; index++) {
            int nextValue = data[index];
            if (isGreatThenNextValue(result, nextValue)) {
                result = data[index];
            } else if (isEqual(result, nextValue)) {
                result = data[index];
            }
        }
        return result;
    }

    private void checkValidation(int[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isEqual(int result, int nextValue) {
        return Math.abs(result) == Math.abs(nextValue) && nextValue > 0;
    }

    private boolean isGreatThenNextValue(int result, int nextValue) {
        return Math.abs(result) > Math.abs(nextValue);
    }
}
