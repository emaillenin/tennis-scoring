package scorer;

import scores.GameScore;

import static scorer.GameScorer.DEUCE_POINTS;
import static scorer.GameScorer.WINNING_POINTS;

public class ScoreFormatter {
    private GameScore score;

    public ScoreFormatter(GameScore score) {
        this.score = score;
    }

    public String formatScore() {
        if (score.getPlayer1Score().equals(WINNING_POINTS)) {
            return "1-0";
        } else if (score.getPlayer2Score().equals(WINNING_POINTS)) {
            return "0-1";
        } else if (score.isPlayer1Advantage()) {
            return "0-0, Advantage player 1";
        } else if (score.isPlayer2Advantage()) {
            return "0-0, Advantage player 2";
        } else if (score.getPlayer1Score().equals(DEUCE_POINTS) && score.getPlayer2Score().equals(DEUCE_POINTS)) {
            return "0-0, Deuce";
        }

        return String.format("0-0, %d-%d", score.getPlayer1Score(), score.getPlayer2Score());
    }
}
