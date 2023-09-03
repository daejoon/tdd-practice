package com.ddoong2;

public class Score {

    private int strike = 0;
    private int ball = 0;

    private Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int strike() {
        return strike;
    }

    public int ball() {
        return ball;
    }

    public static Score create(int strike, int ball) {
        return new Score(strike, ball);
    }
}
