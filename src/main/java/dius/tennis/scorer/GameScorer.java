package dius.tennis.scorer;

import dius.tennis.scores.GameScore;

public class GameScorer {
    public static final Integer DEUCE_POINTS = 40;
    public static final Integer WINNING_POINTS = 50;

    private RegularScorer regularScorer = new RegularScorer();
    private DeuceScorer deuceScorer = new DeuceScorer();
    private AdvantageScorer advantageScorer = new AdvantageScorer();

    public void updateScore(GameScore score, Boolean pointByFirstPlayer) {
        if (score.isPlayer1Advantage() || score.isPlayer2Advantage()) {
            advantageScorer.updatePoints(score, pointByFirstPlayer);
        } else if (score.getPlayer1Score().equals(DEUCE_POINTS) && score.getPlayer2Score().equals(DEUCE_POINTS)) {
            deuceScorer.updatePoints(score, pointByFirstPlayer);
        } else {
            regularScorer.updatePoints(score, pointByFirstPlayer);
        }
    }

}
