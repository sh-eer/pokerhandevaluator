package com.poker;

public class Card {

    private int rank;
    private Suit suit;

    public enum Suit {
        DIAMONDS,
        CLUBS,
        HEARTS,
        SPADES
    }

    private Card() {
    }

    private Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public static Card makeValidCard(String card) {

        Card c = new Card();

        if(card == null || card.length() != 2) {
            throw new IllegalArgumentException("Card must contain rank and suit only.");
        }

        // create a card with rank and suit as pre defined integers to make it easier for us to compare

        switch (card.charAt(0)) {
            case 'T':
                c.rank = 10;
                break;
            case 'J':
                c.rank = 11;
                break;
            case 'Q':
                c.rank = 12;
                break;
            case 'K':
                c.rank = 13;
                break;
            case 'A':
                c.rank = 14;
                break;
            default:
                c.rank = Character.getNumericValue(card.charAt(0));
        }

        switch (card.charAt(1)) {
            case 'c':
                c.suit = Suit.CLUBS;
                break;
            case 'd':
                c.suit = Suit.DIAMONDS;
                break;
            case 'h':
                c.suit = Suit.HEARTS;
                break;
            case 's':
                c.suit = Suit.SPADES;
                break;
        }

        return c;
    }
}
