package com.poker;

public class HandRank {

    public static int rankOfCards(Card[] cards) {
        /*
         * Calculate Rank of Hand using simple nested for loop instead of complex search algorithms
         * Check for the number of matching suits and ranks and based on those we can check for possible hand ranks
         * Such that if we only have only 2 matching suits, we can be sure there is no possibility of Flushes
         * Assign value to handRank (10 to 1) - largest to smallest
         * Return handRank value
         */

        int maxMatchingSuitCount = 0;
        int maxMatchingRankCount = 0;

        // Gets a count of the matching ranks and suits

        for (int i = 0; i < cards.length; ++i) {
            int matchingSuitCounter = 0;
            int matchingRankCounter = 0;
            for (int j = 0; j < cards.length; ++j) {

                if (cards[i].getSuit() == cards[j].getSuit()) {
                    matchingSuitCounter++;
                }
                if (cards[i].getRank() == cards[j].getRank()) {
                    matchingRankCounter++;
                }
            }
            if (matchingSuitCounter > maxMatchingSuitCount) {
                maxMatchingSuitCount = matchingSuitCounter;
            }

            if (matchingRankCounter > maxMatchingRankCount) {
                maxMatchingRankCount = matchingRankCounter;
            }
        }

        // Determine hand ranks based on the counters
        // We know that if we have a Flush we can exclude a 4_of_a_kind and Full_house which have higher rankings

        // Flushes
        if (maxMatchingSuitCount == 5) {
            // royal flush
            if (hasRoyalFlush(cards)) {
                return 10;
            }
            // straight flush
            else if (hasStraightOrStraightFlush(cards)) {
                return 9;
            }
            // flush
            else {
                return 6;
            }
        }

        switch (maxMatchingRankCount) {
            case 4:
                // four_of_a_kind
                 return 8;
            case 3:
                // full house
                if (hasFullHouse(cards)) {
                    return 7;
                }
                // three_of_a_kind
                else {
                    return 4;
                }
            case 2:
                // 2_pair
                if (hasTwoPair(cards)) {
                    return 3;
                }
                // 1_pair
                else {
                    return 2;
                }

            case 1:
                // straight
                if (hasStraightOrStraightFlush(cards)) {
                    return 5;
                }
                // high_card
                else {
                    return 1;
                }
        }

        return 0;
    }

    public static int getWeakHand(Card[] cards) {
        // only keeping to one high card due to time limits
        return cards[0].getRank();
    }

    private static boolean hasRoyalFlush(Card[] cards) {
        // all have the same suit and because this rank needs to have exactly these cards (A,K,Q,J,10)
        // we can simply find out like this in constant time
        if ((cards[0].getRank() == 14) && (cards[1].getRank() == 13) && (cards[2].getRank() == 12)
                && (cards[3].getRank() == 11) && (cards[4].getRank() == 10)) {
            return true;
        }
        return false;
    }

    private static boolean hasFullHouse(Card[] cards) {
        // either xxxyy or yyxxx
        if (cards[0].getRank() == cards[1].getRank() && cards[1].getRank() == cards[2].getRank()) {
            if (cards[3].getRank() == cards[4].getRank()) {
                return true;
            }
        } else if (cards[0].getRank() == cards[1].getRank()) {
            if(cards[2].getRank() == cards[3].getRank() && cards[3].getRank() == cards[4].getRank()){
                return true;
            }
        }
        return false;
    }

    private static boolean hasStraightOrStraightFlush(Card[] cards) {
        // we know that checking for straight or a straight flush would be exactly the same
        // hence, a generic function. We can determine which one it is based on where it is being called
        if (cards[0].getRank() - 1 == cards[1].getRank() && cards[1].getRank() - 1 == cards[2].getRank()
                && cards[2].getRank() - 1 == cards[3].getRank() && cards[3].getRank() - 1 == cards[4].getRank()) {
            return true;
        }
        return false;
    }

    private static boolean hasTwoPair(Card[] cards) {
        // xxyyz
        if (cards[0].getRank() == cards[1].getRank() && cards[2].getRank() == cards[3].getRank()) {
            return true;
        }
        // zxxyy
        else if ((cards[1].getRank() == cards[2].getRank()) && (cards[3].getRank() == cards[4].getRank())) {
            return true;
        }
        // xxzyy
        else if((cards[0].getRank() == cards[1].getRank()) && (cards[3].getRank() == cards[4].getRank())) {
            return true;
        }
        return false;
    }
}
