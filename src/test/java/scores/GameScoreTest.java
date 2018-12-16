package scores;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameScoreTest {

    @Test
    public void addPoints() {
        GameScore gameScore = new GameScore();
        gameScore.addPoints("player 1");
        assertEquals((Integer) 15, gameScore.getPlayer1Score());
    }
}