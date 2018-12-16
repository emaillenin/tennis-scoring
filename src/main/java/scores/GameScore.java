package scores;

public class GameScore {
    private Integer player1Score = 0;
    private Integer player2Score = 0;

    public void scoreForPlayer1() {
        player1Score = newScore(player1Score);
    }

    public void scoreForPlayer2() {
        player2Score = newScore(player2Score);
    }

    public Integer getPlayer1Score() {
        return player1Score;
    }

    public Integer getPlayer2Score() {
        return player2Score;
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
