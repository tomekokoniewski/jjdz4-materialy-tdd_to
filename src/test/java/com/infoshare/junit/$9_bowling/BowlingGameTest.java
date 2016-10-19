package com.infoshare.junit.$9_bowling;

import com.infoshare.junit.bowling.Game;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    public void should_score_zero_when_no_pins_were_knocked() {
        Game game = new Game();
        for(int i=0;i<20;i++) {
            game.roll(0);
        }
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void should_score_20_when_every_roll_knocks_down_one_pin() {
        Game game = new Game();
        for(int i=0;i<20;i++) {
            game.roll(1);
        }
        assertThat(game.score()).isEqualTo(20);
    }


}
