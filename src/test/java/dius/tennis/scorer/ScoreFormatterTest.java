package dius.tennis.scorer;

import org.junit.Before;
import org.junit.Test;
import dius.tennis.scores.GameScore;

import static org.junit.Assert.*;

public class ScoreFormatterTest {

    private String player1 = "player 1";
    private String player2 = "player 2";
    private GameScore score;
    private ScoreFormatter formatter;

    @Before
    public void beforeEach() {
        score = new GameScore();
        formatter = new ScoreFormatter(score, player1, player2);
    }

    @Test
    public void testFirstPoint() {
        score.scoreForPlayer1();

        assertEquals("0-0, 15-0", formatter.formatScore());
    }

    @Test
    public void testPointsForBothPlayers() {
        score.scoreForPlayer1();
        score.scoreForPlayer1();
        score.scoreForPlayer2();

        assertEquals("0-0, 30-15", formatter.formatScore());
    }

    @Test
    public void testPointsForDeuce() {
        score.scoreForPlayer1();
        score.scoreForPlayer1();
        score.scoreForPlayer1();
        score.scoreForPlayer2();
        score.scoreForPlayer2();
        score.scoreForPlayer2();

        assertEquals("0-0, Deuce", formatter.formatScore());
    }

    @Test
    public void testPointsForAdvantage() {
        score.advantagePlayer1();

        assertEquals("0-0, Advantage player 1", formatter.formatScore());
    }

    @Test
    public void testPointsForWin() {
        score.scoreForPlayer1();
        score.scoreForPlayer1();
        score.scoreForPlayer1();
        score.scoreForPlayer1();

        assertEquals("1-0", formatter.formatScore());
    }
}