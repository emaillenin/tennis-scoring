package dius.tennis.scorer;

import dius.tennis.scores.GameScore;

class RegularScorer implements Scorer {

    public void updatePoints(GameScore score, Boolean pointByFirstPlayer) {
        if (pointByFirstPlayer) {
            score.scoreForPlayer1();
        } else {
            score.scoreForPlayer2();
        }
    }

}
