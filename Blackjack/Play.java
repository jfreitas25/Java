package Blackjack;


public class Play {
	
	public static void main(String[] args) {
		Blackjack b = new Blackjack();
		b.ask();
		System.out.println("Your score is " + b.getScore(b.yourCards));
		System.out.println("Dealer's score is " + b.getScore(b.dealerCards));
		b.checkScores();
	}
}

