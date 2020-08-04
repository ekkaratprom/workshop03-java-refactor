public class TennisGame2 {
    public int player1Point;
    public int player2Point;


    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String player1Result = "";
        String player2Result = "";
        String score = "";
        if (player1Point == player2Point && player1Point < 4) { //equalScore
//            if (player1Point == 0)
//                score = "Love";
//            if (player1Point == 1)
//                score = "Fifteen";
//            if (player1Point == 2)
//                score = "Thirty";
//            score += "-All";
            score = equalScore(player1Point);
        }
        if (player1Point == player2Point && player1Point >= 3) //equalScore && point >= 3
            score = "Deuce";

        if (player1Point > 0 && player2Point == 0) { //onlyPlayer1HavePointScore
            if (player1Point == 1)
                player1Result = "Fifteen";
            if (player1Point == 2)
                player1Result = "Thirty";
            if (player1Point == 3)
                player1Result = "Forty";

            player2Result = "Love"; // resultFormat Duplicate
            score = player1Result + "-" + player2Result;
        }
        if (player2Point > 0 && player1Point == 0) { //onlyPlayer2HavePointScore
            if (player2Point == 1)
                player2Result = "Fifteen";
            if (player2Point == 2)
                player2Result = "Thirty";
            if (player2Point == 3)
                player2Result = "Forty";

            player1Result = "Love"; //  resultFormat Duplicate
            score = player1Result + "-" + player2Result;
        }

        if (player1Point > player2Point && player1Point < 4) { // player1Score
            if (player1Point == 2)
                player1Result = "Thirty";
            if (player1Point == 3)
                player1Result = "Forty";
            if (player2Point == 1)
                player2Result = "Fifteen";
            if (player2Point == 2)
                player2Result = "Thirty";
            score = player1Result + "-" + player2Result; //  resultFormat Duplicate
        }
        if (player2Point > player1Point && player2Point < 4) { // player2Score
            if (player2Point == 2)
                player2Result = "Thirty";
            if (player2Point == 3)
                player2Result = "Forty";
            if (player1Point == 1)
                player1Result = "Fifteen";
            if (player1Point == 2)
                player1Result = "Thirty";
            score = player1Result + "-" + player2Result; // return resultFormat Duplicate
        }

        if (player1Point > player2Point && player2Point >= 3) { //hard code --> advantagePlayer()
            score = "Advantage player1";
        }

        if (player2Point > player1Point && player1Point >= 3) { //hard code --> advantagePlayer()
            score = "Advantage player2";
        }

        if (player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2) { //hard code --> endGame()
            score = "Win for player1";
        }
        if (player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2) { //hard code --> endGame()
            score = "Win for player2";
        }
        return score;
    }

    public void player1Score() { // Duplicate method --> receivePoint()
        player1Point++;
    }

    public void player2Score() { // Duplicate method --> receivePoint()
        player2Point++;
    }

    public String equalScore(int playerPoint){
        String score = "";
        if (playerPoint == 0)
            score = "Love";
        if (playerPoint == 1)
            score = "Fifteen";
        if (playerPoint == 2)
            score = "Thirty";
        score += "-All";
        return score;
    }


    public void wonPoint(String player) {
        //if (player.equals("player1")) // 1 => NullPointerException (NPE)
        if ("player1".equals(player)) { // 2 => Null safety
            player1Score();
        } else {
            player2Score();
        }
    }
}
