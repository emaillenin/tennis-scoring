package dius.tennis.scorer;

import dius.tennis.scores.GameScore;

class AdvantageScorer implements Scorer {

    public void updatePoints(GameScore score, Boolean pointByFirstPlayer) {
        if(pointByFirstPlayer && score.isPlayer1Advantage()) {
            score.scoreForPlayer1();
        } else if (!pointByFirstPlayer && score.isPlayer2Advantage()) {
            score.scoreForPlayer2();
        }
        score.resetAdvantage();
    }

}
