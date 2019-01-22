package com.ddoong2.bowling;

import com.dddoong2.bowling.Game;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BowlingTest
 *
 * Created by kdj on 2018. 8. 5.
 */
public class BowlingTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void canRoll() {
        game.roll(0);
    }

    private void rollMany(int pins, int frames) {
        for (int i = 0; i < frames; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void gutterGame() {
        rollMany(0, 20);
        assertThat(game.getScore(), is(0));
    }

    @Test
    public void allOnes() {
        rollMany(1, 20);
        assertThat(game.getScore(), is(20));
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    @Test
    public void oneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.getScore(), is(16));
    }

    @Test
    public void oneStrike() {
        rollStrike();
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);
        assertThat(game.getScore(), is(26));
    }

    private void rollStrike() {
        game.roll(10);
    }

    @Test
    public void perfectGame() {
        rollMany(10, 10);
        game.roll(10);
        game.roll(10);
        assertThat(game.getScore(), is(300));
    }
}