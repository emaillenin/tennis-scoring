package dius.tennis.scorer;

import dius.tennis.scores.GameScore;

public interface Scorer {
    void updatePoints(GameScore score, Boolean pointByFirstPlayer);
}
