package com.poker;

import com.poker.PokerHand.Result;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class PokerHandTest {
	
	@Test
	public void highCardWin() {
		PokerHand hand1 = new PokerHand("As 2h 5c Jd Td");
		PokerHand hand2 = new PokerHand("Kc 2s 5h Jh Tc");

		PokerHand hand3 = new PokerHand("Ah Kh Qh Jh Th");

		PokerHand hand4 = new PokerHand("Kc Ks 5h Jh Tc");
		PokerHand hand5 = new PokerHand("Ac As 5h Jh Tc");

		PokerHand hand6 = new PokerHand("Ks Js 9s 7s 3s");

		assertEquals(Result.WIN, hand1.compareWith(hand2));
		assertEquals(Result.LOSS, hand2.compareWith(hand1));
		assertEquals(Result.WIN, hand3.compareWith(hand4));
		assertEquals(Result.LOSS, hand4.compareWith(hand5));
		assertEquals(Result.WIN, hand5.compareWith(hand4));

	}
}
