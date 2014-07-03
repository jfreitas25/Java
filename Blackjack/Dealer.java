package Blackjack;


public class Dealer {
	

	public static String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	
	public static String dealcard() {
		int index = (int)(Math.random() * 13);
		String card = cards[index];
		return card;
	}
	
	public static String[] dealerGo(String[] hand){
		Blackjack b = new Blackjack();
		int handsize = 1;
		int score = b.getScore(hand);
		while (score < 17) {
			hand[handsize] = dealcard();
			handsize++;
			score = b.getScore(hand);
		}
		return hand;
	}
}
