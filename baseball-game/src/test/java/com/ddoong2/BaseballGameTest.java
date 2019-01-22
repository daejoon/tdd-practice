package com.ddoong2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BaseballGameTest {

    private BaseballGame game;

    @Before
    public void setUp() throws Exception {
        game = new BaseballGame("123");
    }

    @Test
    public void 숫자가_모두_틀리면_0스트라이크_0볼이다() {
        assertMatch(game.guess("987"), 0, 0);
    }

    @Test(expected = DuplicationNumberException.class)
    public void 숫자가겹치면_DuplicationNumberException이_발생한다() {
        assertMatch(game.guess("999"), 0, 3);
    }

    @Test
    public void 숫자가값과_위치가_같으면_스트라이크_숫자값은_같고_위치는_다르면_볼이다() {
        assertMatch(game.guess("197"), 1, 0);
        assertMatch(game.guess("397"), 0, 1);
        assertMatch(game.guess("129"), 2, 0);
        assertMatch(game.guess("312"), 0, 3);
        assertMatch(game.guess("123"), 3, 0);
    }

    private void assertMatch(Score score, int strike, int ball) {
        assertThat(score.strike(), is(strike));
        assertThat(score.ball(), is(ball));
    }
}
