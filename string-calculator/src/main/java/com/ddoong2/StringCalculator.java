package com.ddoong2;

import java.util.Arrays;

public class StringCalculator {
    private String text;

    public StringCalculator(String text) {
        this.text = text;
    }

    public int result() {
        String strNums = this.text;

        if (isEmpty(strNums)) {
            return 0;
        } else if (isSingle(strNums)) {
            return getSumBySingle(strNums);
        } else if (isMulti(strNums)) {
            return getSumByMulti(strNums);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private Integer getSumBySingle(String strNums) {
        return Integer.valueOf(strNums);
    }

    private int getSumByMulti(String strNums) {
        return Arrays.stream(strNums.split("(,|:)"))
                .map(Integer::valueOf)
                .reduce(0, (num, num2) -> num + num2)
                .intValue();
    }

    private boolean isMulti(String strNums) {
        return strNums.indexOf(",") >= 0 || strNums.indexOf(":") >= 0;
    }

    private boolean isSingle(String strNums) {
        return strNums.length() == 1;
    }

    private boolean isEmpty(String strNums) {
        return strNums == null || strNums.isEmpty();
    }
}
