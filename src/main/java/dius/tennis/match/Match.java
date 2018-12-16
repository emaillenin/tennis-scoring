package dius.tennis.match;

import dius.tennis.scorer.GameScorer;
import dius.tennis.scorer.ScoreFormatter;
import dius.tennis.scores.GameScore;

public class Match {
    private final String player1;
    private final String player2;
    private GameScore score = new GameScore();
    private GameScorer scorer = new GameScorer();

    public Match(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void pointWonBy(String player) {
        scorer.updateScore(score, player.equals(player1));
    }

    public String score() {
        return new ScoreFormatter(score, player1, player2).formatScore();
    }
}
