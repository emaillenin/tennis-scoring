package scorer;

import org.junit.Test;
import scores.GameScore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameScorerTest {

    @Test
    public void updatePointsForPlayer1() {
        GameScore gameScore = new GameScore();
        GameScorer gameScorer = new GameScorer();

        gameScorer.updateScore(gameScore, true);

        assertEquals((Integer) 15, gameScore.getPlayer1Score());
        assertEquals((Integer) 0, gameScore.getPlayer2Score());
    }

    @Test
    public void updatePointsForPlayer2() {
        GameScore gameScore = new GameScore();
        GameScorer gameScorer = new GameScorer();

        gameScorer.updateScore(gameScore, false);

        assertEquals((Integer) 0, gameScore.getPlayer1Score());
        assertEquals((Integer) 15, gameScore.getPlayer2Score());
    }

    @Test
    public void addNewPointsForExistingGameScore() {
        GameScore gameScore = new GameScore();
        GameScorer gameScorer = new GameScorer();
        gameScore.scoreForPlayer1();

        gameScorer.updateScore(gameScore, true);

        assertEquals((Integer) 30, gameScore.getPlayer1Score());
        assertEquals((Integer) 0, gameScore.getPlayer2Score());
    }

    @Test
    public void handleDeucePoints() {
        GameScore gameScore = new GameScore();
        GameScorer gameScorer = new GameScorer();
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
}