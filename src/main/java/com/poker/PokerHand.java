package com.poker;

public class PokerHand {

	String hand;
	private int handRank;
	private int weakRank;
	Card[] cards = new Card[5];
	
	public enum Result {
		WIN,
		LOSS,
		TIE;
	}

	public PokerHand(String hand) {
		// assign hand as well as the HandRank
		this.hand = hand;
		cards = makeHandIntoArrayOfCards(hand);
		setHandRank();
		this.weakRank = HandRank.getWeakHand(cards);
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	public int getHandRank() {
		return handRank;
	}

	public void setHandRank() {
		handRank = HandRank.rankOfCards(cards);
	}

	public int getWeakHand() {
		return weakRank;
	}

	public Result compareWith(PokerHand hand) {
		/*
		 * As we know the HandRank of both hands, and it is an integer value, we simply
		 * check for the largest hand, if they both match, it is a TIE,
		 * If in case of a TIE, we also check for the weak rank which checks for the high card
		 * However the weak hand is only based on one high card (didn't have time to implement)
		 */

		if (getHandRank() == hand.getHandRank()) {
			if (getWeakHand() == hand.getWeakHand()) {
				return Result.TIE;
			} else if (getWeakHand() > hand.getWeakHand()) {
				return Result.WIN;
			} else {
				return Result.LOSS;
			}
		} else if (getHandRank() > hand.getHandRank()) {
			return Result.WIN;
		} else {
			return Result.LOSS;
		}
	}

	private Card[] makeHandIntoArrayOfCards (String hand) {
		// this method allows us to save the hand as array of cards so that we can easily create a HandRank from those cards
		String[] parts = hand.split(" ");

		if (parts.length != 5) {
			throw new IllegalArgumentException("Each hand should consist of 5 cards exactly.");
		}

		// store cards as card objects
		Card[] cards = new Card[5];
		int index = 0;
		for (String part: parts) {
			cards[index++] = Card.makeValidCard(part);
		}

		// sort the cards so that comparing for HandRank can be done in constant time
		sortCards(cards);
		return cards;
	}

	private void sortCards(Card[] cards) {
		// using simple bubble sort as we only have 5 cards
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4-i; j++)
				if (cards[j].getRank() < cards[j+1].getRank()) {
					// swap
					Card temp = cards[j];
					cards[j] = cards[j+1];
					cards[j+1] = temp;
				}
	}

}
