package dius.tennis.scorer;

import dius.tennis.scores.GameScore;

class DeuceScorer implements Scorer {

    public void updatePoints(GameScore score, Boolean pointByFirstPlayer) {
        if (pointByFirstPlayer) {
            score.advantagePlayer1();
        } else {
            score.advantagePlayer2();
        }
    }

}
