package com.example.tenis.quilmes.model;

public class EloRating {

    /**
     * Constructor
     */
    public EloRating() {
    }
    
    /**
     * Calculate rating for 2 players
     * 
     * @param player1Rating
     *            The rating of Player1
     * @param player2Rating
     *            The rating of Player2
     * @param outcome
     *            A string representing the game result for Player1 
     *            "+" winner
     *            "=" draw 
     *            "-" lose
     * @return New player rating
     */
    public static int calculate2PlayersRating(int player1Rating, int player2Rating, String outcome) {
        double actualScore;

        // winner
        if (outcome.equals("+")) {
            actualScore = 1.0;
            // draw
        } else if (outcome.equals("=")) {
            actualScore = 0.5;
            // lose
        } else if (outcome.equals("-")) {
            actualScore = 0;
            // invalid outcome
        } else {
            return player1Rating;
        }

        // calculate expected outcome
        double exponent = (double) (player2Rating - player1Rating) / 400;
        double expectedOutcome = (1 / (1 + (Math.pow(10, exponent))));

        // K-factor
        int K = 32;

        // calculate new rating
        int newRating = (int) Math.round(player1Rating + K * (actualScore - expectedOutcome));

        return newRating;
    }


}