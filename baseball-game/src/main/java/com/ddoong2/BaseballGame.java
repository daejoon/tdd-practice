package com.ddoong2;

public class BaseballGame {
    private String answer;

    public BaseballGame(String answer) {
        this.answer = answer;
    }

    public Score guess(String guess) {
        int strike = 0;
        int ball = 0;

        for (int idx = 0; idx < guess.length(); idx++) {
            char currentGuess = guess.charAt(idx);
            char currentAnswer = answer.charAt(idx);

            if ( isDuplication(currentGuess, guess) ) {
                throw new DuplicationNumberException();
            } else if (isStrike(currentGuess, currentAnswer)) {
                strike++;
            } else if (isBall(currentGuess, currentAnswer)) {
                ball++;
            }
        }

        return Score.create(strike, ball);
    }

    private boolean isBall(char currentGuess, char currentAnswer) {
        return currentAnswer != currentGuess &&
                isExist(currentGuess);
    }

    private boolean isStrike(char currentGuess, char currentAnswer) {
        return currentAnswer == currentGuess;
    }

    private boolean isExist(char currentGuess) {
        for (int idx = 0; idx < answer.length(); idx++) {
            if (currentGuess == answer.charAt(idx)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplication(char currentGuess, String guess) {
        int count = 0;
        for (int idx = 0; idx < guess.length(); idx++) {
            if (currentGuess == guess.charAt(idx)) {
                count++;
            }
        }
        return count > 1 ? true : false;
    }
}
