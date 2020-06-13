# Poker Hand Evaluator

A simple program that compares poker hands and determines a winner.

## 1. Hand

A poker hand has a constructor that accepts a string containing 5 cards: 

```
PokerHand hand = new PokerHand("KS 2H 5C JD TD");
```

and a method to compare itself to another hand

```
public enum Result {
	WIN,
	LOSS,
	TIE;
}
	
public Result compareWith(PokerHand hand) {
	/*
	 * Your code here
	 */
	 return Result.TIE;
}
```

The characteristics of the string of cards are:
*   A space is used as card seperator
*   Each card consists of two characters
*   The first character is the value of the card, valid characters are: `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `T`(en), `J`(ack), `Q`(ueen), `K`(ing), `A`(ce)
*   The second character represents the suit, valid characters are: `S`(pades), `H`(earts), `D`(iamonds), `C`(lubs)

The result of the poker hand compare can be one of the 3 options defined by the `PokerHand.Result` enum.

The ranking of the hands follows the [Texas Hold'em rules](http://www.wsop.com/how-to-play-poker/images/how-to-ranking.jpg)

## 2. Extra

*  uses maven (see below)

#### Maven

Maven is a dependency management tool that can be easily downloaded and installed. The given project already includes a pom.xml so there should be no additional setup required.

Tests can be run from the command line like so:  
`mvn test`
