package dius.tennis.scores;

public class GameScore {
    private Integer player1Score = 0;
    private Integer player2Score = 0;
    private Boolean player1Advantage = false;
    private Boolean player2Advantage = false;

    public void scoreForPlayer1() {
        player1Score = newScore(player1Score);
    }

    public void scoreForPlayer2() {
        player2Score = newScore(player2Score);
    }

    public void advantagePlayer1() {
        player1Advantage = true;
    }

    public void advantagePlayer2() {
        player2Advantage = true;
    }

    public void resetAdvantage() {
        player1Advantage = false;
        player2Advantage = false;
    }

    public Integer getPlayer1Score() {
        return player1Score;
    }

    public Integer getPlayer2Score() {
        return player2Score;
    }

    public Boolean isPlayer1Advantage() {
        return player1Advantage;
    }

    public Boolean isPlayer2Advantage() {
        return player2Advantage;
    }

    private Integer newScore(Integer currentScore) {
        switch(currentScore) {
            case 0: return 15;
            case 15: return 30;
            case 30: return 40;
        }
        return 50;
    }
}
