package com.ddoong2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class PrimeNumberTest {


    private PrimeNumbers primeNumber;

    @Before
    public void setUp() throws Exception {
        primeNumber = new PrimeNumbers();
    }

    @Test
    public void test_1이하의_숫자를_입력하면_IllegalArgumentException이_발생한다() {
        Exception thrown = null;
        try {
            primeNumber.process(1);
        } catch (Exception e) {
            thrown = e;
        }
        assertThat(thrown, instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void test_2를_입력하면_2인_배열을_반환한다() {
        int[] result = primeNumber.process(2);
        assertArrayEquals(new int[] {2}, result);
    }

    @Test
    public void test_3을_입력하면_2와_3인_배열을_반환한다() {
        int[] result = primeNumber.process(3);
        assertArrayEquals(new int[] {2, 3}, result);
    }

    @Test
    public void test_입력값에_해당하는_소인수분해를_반환한다() {
        int[] result = primeNumber.process(4);
        assertArrayEquals(new int[] {2, 3}, result);

        result = primeNumber.process(5);
        assertArrayEquals(new int[] {2, 3, 5}, result);

        result = primeNumber.process(6);
        assertArrayEquals(new int[] {2, 3, 5}, result);

        result = primeNumber.process(7);
        assertArrayEquals(new int[] {2, 3, 5, 7}, result);

        result = primeNumber.process(8);
        assertArrayEquals(new int[] {2, 3, 5, 7}, result);

        result = primeNumber.process(9);
        assertArrayEquals(new int[] {2, 3, 5, 7}, result);

        result = primeNumber.process(10);
        assertArrayEquals(new int[] {2, 3, 5, 7}, result);

        result = primeNumber.process(11);
        assertArrayEquals(new int[] {2, 3, 5, 7, 11}, result);
    }

}
