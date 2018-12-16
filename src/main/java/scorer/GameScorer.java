package scorer;

import scores.GameScore;

public class GameScorer {
    private final Integer DEUCE_POINTS = 40;

    public void updateScore(GameScore score, Boolean pointByFirstPlayer) {
        if (score.getPlayer1Score().equals(DEUCE_POINTS) && score.getPlayer2Score().equals(DEUCE_POINTS)) {
            updateDeucePoints(score, pointByFirstPlayer);
        } else {
            updateRegularPoints(score, pointByFirstPlayer);
        }
    }

    private void updateDeucePoints(GameScore score, Boolean pointByFirstPlayer) {
        if (pointByFirstPlayer) {
            score.advantagePlayer1();
        } else {
            score.advantagePlayer2();
        }
    }

    private void updateRegularPoints(GameScore score, Boolean pointByFirstPlayer) {
        if (pointByFirstPlayer) {
            score.scoreForPlayer1();
        } else {
            score.scoreForPlayer2();
        }
    }
}
