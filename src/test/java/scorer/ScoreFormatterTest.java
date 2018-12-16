package scorer;

import org.junit.Test;
import scores.GameScore;

import static org.junit.Assert.*;

public class ScoreFormatterTest {

    @Test
    public void testFirstPoint() {
        var score = new GameScore();
        score.scoreForPlayer1();

        var formatter = new ScoreFormatter(score);

        assertEquals("0-0, 15-0", formatter.formatScore());

    }
}