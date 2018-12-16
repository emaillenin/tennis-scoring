package scorer;

import org.junit.Test;
import scores.GameScore;

import static org.junit.Assert.*;

public class ScoreFormatterTest {

    private String player1 = "player 1";
    private String player2 = "player 2";

    @Test
    public void testFirstPoint() {
        GameScore score = new GameScore();
        score.scoreForPlayer1();

        ScoreFormatter formatter = new ScoreFormatter(score, player1, player2);

        assertEquals("0-0, 15-0", formatter.formatScore());
    }

    @Test
    public void testPointsForBothPlayers() {
        GameScore score = new GameScore();
        score.scoreForPlayer1();
        score.scoreForPlayer1();
        score.scoreForPlayer2();

        ScoreFormatter formatter = new ScoreFormatter(score, player1, player2);

        assertEquals("0-0, 30-15", formatter.formatScore());
    }

    @Test
    public void testPointsForDeuce() {
        GameScore score = new GameScore();
        score.scoreForPlayer1();
        score.scoreForPlayer1();
        score.scoreForPlayer1();
        score.scoreForPlayer2();
        score.scoreForPlayer2();
        score.scoreForPlayer2();

        ScoreFormatter formatter = new ScoreFormatter(score, player1, player2);

        assertEquals("0-0, Deuce", formatter.formatScore());
    }

    @Test
    public void testPointsForAdvantage() {
        GameScore score = new GameScore();
        score.advantagePlayer1();

        ScoreFormatter formatter = new ScoreFormatter(score, player1, player2);

        assertEquals("0-0, Advantage player 1", formatter.formatScore());
    }

    @Test
    public void testPointsForWin() {
        GameScore score = new GameScore();
        score.scoreForPlayer1();
        score.scoreForPlayer1();
        score.scoreForPlayer1();
        score.scoreForPlayer1();

        ScoreFormatter formatter = new ScoreFormatter(score, player1, player2);

        assertEquals("1-0", formatter.formatScore());
    }
}