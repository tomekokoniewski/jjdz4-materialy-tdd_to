package com.infoshare.junit.bowling;

public class Game {
    private int score = 0;
    private int roll = 1;
    private int previousRound;
    private boolean spare = false;

    public int getScore(){
        return score;
    }

    public void roll(int rollScore){

        score +=rollScore;





    }

}
