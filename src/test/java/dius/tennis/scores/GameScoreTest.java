package dius.tennis.scores;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameScoreTest {

    private GameScore gameScore;

    @Before
    public void beforeEach() {
        gameScore = new GameScore();
    }

    @Test
    public void testAddPoints() {
        gameScore.scoreForPlayer1();

        assertEquals((Integer) 15, gameScore.getPlayer1Score());
    }

    @Test
    public void testDoublePoints() {
        gameScore.scoreForPlayer2();
        gameScore.scoreForPlayer2();

        assertEquals((Integer) 30, gameScore.getPlayer2Score());
    }
}