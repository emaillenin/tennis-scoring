package dius.tennis.scorer;

import org.junit.Before;
import org.junit.Test;
import dius.tennis.scores.GameScore;

import static org.junit.Assert.*;

public class GameScorerTest {

    private GameScore gameScore;
    private  GameScorer gameScorer;

    @Before
    public void beforeEach() {
        gameScore = new GameScore();
        gameScorer = new GameScorer();
    }

    @Test
    public void testPointsForPlayer1() {
        gameScorer.updateScore(gameScore, true);

        assertEquals((Integer) 15, gameScore.getPlayer1Score());
        assertEquals((Integer) 0, gameScore.getPlayer2Score());
    }

    @Test
    public void testPointsForPlayer2() {
        gameScorer.updateScore(gameScore, false);

        assertEquals((Integer) 0, gameScore.getPlayer1Score());
        assertEquals((Integer) 15, gameScore.getPlayer2Score());
    }

    @Test
    public void testNewPointsForExistingGameScore() {
        gameScore.scoreForPlayer1();
        gameScorer.updateScore(gameScore, true);

        assertEquals((Integer) 30, gameScore.getPlayer1Score());
        assertEquals((Integer) 0, gameScore.getPlayer2Score());
    }

    @Test
    public void testDeucePoints() {
        gameScore.scoreForPlayer1();
        gameScore.scoreForPlayer1();
        gameScore.scoreForPlayer1();
        gameScore.scoreForPlayer2();
        gameScore.scoreForPlayer2();
        gameScore.scoreForPlayer2();

        gameScorer.updateScore(gameScore, true);

        assertEquals((Integer) 40, gameScore.getPlayer1Score());
        assertEquals((Integer) 40, gameScore.getPlayer2Score());
        assertTrue(gameScore.isPlayer1Advantage());
    }

    @Test
    public void testAdvantagePlayer() {
        gameScore.scoreForPlayer1();
        gameScore.scoreForPlayer1();
        gameScore.scoreForPlayer1();
        gameScore.scoreForPlayer2();
        gameScore.scoreForPlayer2();
        gameScore.scoreForPlayer2();

        gameScorer.updateScore(gameScore, true);
        gameScorer.updateScore(gameScore, false);

        assertEquals((Integer) 40, gameScore.getPlayer1Score());
        assertEquals((Integer) 40, gameScore.getPlayer2Score());
        assertFalse(gameScore.isPlayer1Advantage());
        assertFalse(gameScore.isPlayer2Advantage());
    }

    @Test
    public void testAdvantageWin() {
        gameScore.scoreForPlayer1();
        gameScore.scoreForPlayer1();
        gameScore.scoreForPlayer1();
        gameScore.scoreForPlayer2();
        gameScore.scoreForPlayer2();
        gameScore.scoreForPlayer2();

        gameScorer.updateScore(gameScore, true);
        gameScorer.updateScore(gameScore, true);

        assertEquals((Integer) 50, gameScore.getPlayer1Score());
        assertEquals((Integer) 40, gameScore.getPlayer2Score());
        assertFalse(gameScore.isPlayer1Advantage());
        assertFalse(gameScore.isPlayer2Advantage());
    }
}