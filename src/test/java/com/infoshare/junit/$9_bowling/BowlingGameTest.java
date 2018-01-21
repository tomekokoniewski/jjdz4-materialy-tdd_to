package com.infoshare.junit.$9_bowling;

//import com.infoshare.junit.bowling.Game;
import com.infoshare.junit.bowling.Game;
import org.junit.Before;
import org.junit.Test;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

//1    gra ma dziesięć rund (frame)
//2    w każdej rundzie gracz ma dwie rzuty (roll), żeby strącić dziesięć kręgli
//3    gracz zdobywa tyle punktów ile strącił kręgli, plus bonusy za “strike” i “spare”
//4            “strike” jest wtedy, gdy gracza strąci dziesięć kręgli w jednym rzucie, dostanie wtedy dodatkowo tyle punktów ile
//    strąci kręgli w dwóch następnych rzutach
//5 “spare” to sytuacja, gdy gracz strąci dziesięć kręgli w dwóch rzutach, dodatkowo dostaje wtedy tyle punktów ile
//    strąci kręgli w następnym rzucie
//6    jeżeli gracz zdobędzie “strike” albo “spare” w dziesiątej rundzie to ma dwa (jeden w przypadku “spare”)
//7    dodatkowe rzuty na zdobycie dodatkowych punktów
//8    punkty zdobyte po ostatniej rundzie naliczane są tylko raz
//  która runda (frame)
//  który rzut (roll)


//przypadek1 - każda runda bez punktów - wynik zero
//przypadek2 - każda runda z max il punktów  -  wynik 300
//przypadek3 - bez pkt + strike
// bez pkt + spare
//strike + spare

    private Game game;



/* the old one
    @Before
    public void  before(){
        game = new Game();
    }

    @Test
    public void noHitsInAllRounds() {
    //for (int i=0;i<20;i++){
    //game.roll(0);

        IntStream.iterate(0, i -> ++i).limit(20).forEach(i -> game.roll(0));

        assertThat(game.getScore()).isEqualTo(0);
    }

    @Test
    public void onePointInAllRoll() {
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertThat(game.getScore()).isEqualTo(20);
    }

    @Test
    public void twoSpareAndAllZero() {
        for (int i = 0; i < 20; i++) {
            game.roll((i<4)? 5:0);
        }
        assertThat(game.getScore()).isEqualTo(25);
    }




    /*
    @Test
    public void strikesInAllRound(){
        for(int i=0;i<12;i++){

        }
    }
    */

    private void rollIteration(int rolls, IntConsumer score) {
        IntStream.iterate(0,i -> ++i).limit(rolls).forEach(score);
    }

    @Before
    public void before() {
        game = new Game();
    }

    @Test
    public void noHitsInAllRounds() {
        rollIteration(20,i -> game.roll(0));
        assertThat(game.getScore()).isEqualTo(0);
    }

    @Test
    public void onePointEveryRoll() {
        rollIteration(20,i -> game.roll(1));
        assertThat(game.getScore()).isEqualTo(20);
    }

    @Test
    public void twoSparesAndZeros() {
        rollIteration(20,i -> game.roll((i < 4)? 5 : 0));
        assertThat(game.getScore()).isEqualTo(25);
    }



}




