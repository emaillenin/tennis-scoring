package dius.tennis.scorer;

import dius.tennis.scores.GameScore;

import static dius.tennis.scorer.GameScorer.DEUCE_POINTS;
import static dius.tennis.scorer.GameScorer.WINNING_POINTS;

public class ScoreFormatter {
    private GameScore score;
    private final String player1;
    private final String player2;

    public ScoreFormatter(GameScore score, String player1, String player2) {
        this.score = score;
        this.player1 = player1;
        this.player2 = player2;
    }

    public String formatScore() {
        if (score.getPlayer1Score().equals(WINNING_POINTS)) {
            return "1-0";
        } else if (score.getPlayer2Score().equals(WINNING_POINTS)) {
            return "0-1";
        } else if (score.isPlayer1Advantage()) {
            return String.format("0-0, Advantage %s", player1);
        } else if (score.isPlayer2Advantage()) {
            return String.format("0-0, Advantage %s", player2);
        } else if (score.getPlayer1Score().equals(DEUCE_POINTS) && score.getPlayer2Score().equals(DEUCE_POINTS)) {
            return "0-0, Deuce";
        }

        return String.format("0-0, %d-%d", score.getPlayer1Score(), score.getPlayer2Score());
    }
}
