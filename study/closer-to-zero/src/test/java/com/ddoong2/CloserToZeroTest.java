package com.ddoong2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CloserToZeroTest {

    private CloserToZero closerToZero;

    @Before
    public void setUp() throws Exception {
        closerToZero = new CloserToZero();
    }

    @Test
    public void NULL이거나_배열의_길이가_0인_인자를_전달하면_IllegalArgumentException이_발생한다() {
        IllegalArgumentException thrown = null;
        try {
            closerToZero.find(null);
        } catch (IllegalArgumentException e) {
            thrown = e;
        }
        assertThat(thrown, instanceOf(IllegalArgumentException.class));

        try {
            closerToZero.find(new int[0]);
        } catch (IllegalArgumentException e) {
            thrown = e;
        }
        assertThat(thrown, instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void 배열_개수가_1개인_배열에서_가장가까운수는_그_한개이다() {
        assertThat(closerToZero.find(new int[] {1}), is(1));
        assertThat(closerToZero.find(new int[] {2}), is(2));
    }

    @Test
    public void 배열이_두개이상의_양수일때_가장가까운수를_구한다() {
        assertThat(closerToZero.find(new int[] {1, 2, 3, 4, 5, 6,}), is(1));
        assertThat(closerToZero.find(new int[] {6, 5, 4, 3, 2, 1}), is(1));
        assertThat(closerToZero.find(new int[] {2, 1, 3, 4}), is(1));
    }

    @Test
    public void 배열이_거리가_같은_정수일때는_양수를_리턴한다() {
        assertThat(closerToZero.find(new int[] {1, -1}), is(1));
        assertThat(closerToZero.find(new int[] {-2, 2, 3}), is(2));
    }

    @Test
    public void 배열의_가장_가까운_정수를_구한다() {
        assertThat(closerToZero.find(new int[] {-2, 3, 4, 5, 1}), is(1));
        assertThat(closerToZero.find(new int[] {-2, 2, 3, 4, 5}), is(2));
        assertThat(closerToZero.find(new int[] {2, 3, 4, 5, -1}), is(-1));
    }
}
