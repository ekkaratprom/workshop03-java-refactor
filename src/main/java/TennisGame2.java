public class TennisGame2 {
    public int player1Point;
    public int player2Point;


    private final String player1Name;
    private final String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {


        // equal score not deuce
        if (player1Point == player2Point && player1Point < 3) { //equalScore
            return equalScore(player1Point);
        }

        // Deuce
        if (player1Point == player2Point ) //equalScore && point >= 3
            return  "Deuce";

        //normal case player 1
        if (player1Point > 0 && player2Point == 0) {
            return formatResult(normalScore(player1Point),"Love");
        }

        // normal case player 2
        if (player2Point > 0 && player1Point == 0 ) {
            return formatResult("Love",normalScore(player2Point));
        }

        if (player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2) {
            return "Win for " + player1Name;
        }

        if (player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2) {
            return "Win for " + player2Name;
        }

        if (player1Point > player2Point && player2Point >= 3) { //hard code
            return  "Advantage " + player1Name;
        }

        if (player2Point > player1Point && player1Point >= 3) { //hard code
            return "Advantage " + player2Name;
        }


        return formatResult(normalScore(player1Point),normalScore(player2Point));
    }

    public void player1Score() {
        player1Point++;
    }

    public void player2Score() {
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
        return score + "-All";
    }

    public String normalScore(int playerPoint){
        String score = "";
        if (playerPoint == 1){
            score =  "Fifteen";}
        if (playerPoint == 2){
            score = "Thirty";}
        if (playerPoint == 3){
            score = "Forty";}
        return score;

    }

    public String formatResult(String s1,String s2){
        return s1 + "-" + s2;
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
