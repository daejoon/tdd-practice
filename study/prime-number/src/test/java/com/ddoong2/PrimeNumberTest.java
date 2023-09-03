package com.ddoong2;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void test_2를_입력하면_2인_배열을_반환한다() {
        int[] result = primeNumber.process(2);

        assertThat(new int[]{2}).containsSequence(result);
    }

    @Test
    public void test_3을_입력하면_2와_3인_배열을_반환한다() {
        int[] result = primeNumber.process(3);
        assertThat(new int[] {2, 3}).containsSequence(result);
    }

    @Test
    public void test_입력값에_해당하는_소인수분해를_반환한다() {
        int[] result = primeNumber.process(4);
        assertThat(new int[] {2, 3}).containsSequence(result);

        result = primeNumber.process(5);
        assertThat(new int[] {2, 3, 5}).containsSequence(result);

        result = primeNumber.process(6);
        assertThat(new int[] {2, 3, 5}).containsSequence(result);

        result = primeNumber.process(7);
        assertThat(new int[] {2, 3, 5, 7}).containsSequence(result);

        result = primeNumber.process(8);
        assertThat(new int[] {2, 3, 5, 7}).containsSequence(result);

        result = primeNumber.process(9);
        assertThat(new int[] {2, 3, 5, 7}).containsSequence(result);

        result = primeNumber.process(10);
        assertThat(new int[] {2, 3, 5, 7}).containsSequence(result);

        result = primeNumber.process(11);
        assertThat(new int[] {2, 3, 5, 7, 11}).contains(result);
    }

}
