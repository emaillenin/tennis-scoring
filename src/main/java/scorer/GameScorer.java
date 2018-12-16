package scorer;

import scores.GameScore;

public class GameScorer {
    public static final Integer DEUCE_POINTS = 40;
    public static final Integer WINNING_POINTS = 50;

    public void updateScore(GameScore score, Boolean pointByFirstPlayer) {
        if (score.isPlayer1Advantage() || score.isPlayer2Advantage()) {
            updateAdvantagePoints(score, pointByFirstPlayer);
        } else if (score.getPlayer1Score().equals(DEUCE_POINTS) && score.getPlayer2Score().equals(DEUCE_POINTS)) {
            updateDeucePoints(score, pointByFirstPlayer);
        } else {
            updateRegularPoints(score, pointByFirstPlayer);
        }
    }

    private void updateAdvantagePoints(GameScore score, Boolean pointByFirstPlayer) {
        if(pointByFirstPlayer && score.isPlayer1Advantage()) {
            score.scoreForPlayer1();
        } else if (!pointByFirstPlayer && score.isPlayer2Advantage()) {
            score.scoreForPlayer2();
        }
        score.resetAdvantage();
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
