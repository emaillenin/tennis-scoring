package dius.tennis.scores;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameScoreTest {

    @Test
    public void testAddPoints() {
        GameScore gameScore = new GameScore();
        gameScore.scoreForPlayer1();
        assertEquals((Integer) 15, gameScore.getPlayer1Score());
    }

    @Test
    public void testDoublePoints() {
        GameScore gameScore = new GameScore();
        gameScore.scoreForPlayer2();
        gameScore.scoreForPlayer2();
        assertEquals((Integer) 30, gameScore.getPlayer2Score());
    }
}