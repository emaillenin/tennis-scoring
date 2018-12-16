package scorer;

import scores.GameScore;

public class GameScorer {

    public void updateScore(GameScore score, Boolean pointByFirstPlayer) {
        if (pointByFirstPlayer) {
            score.scoreForPlayer1();
        } else {
            score.scoreForPlayer2();
        }
    }
}
