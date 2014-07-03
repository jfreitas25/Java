package Blackjack;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Blackjack {
	
	public String[] yourCards;
	public String[] dealerCards;
	public int yourHandSize;
	public int dealerHandSize;
	public ConcurrentHashMap<String,Integer> scoreTable;
	
	public Blackjack() {
		yourCards = new String[10];
		dealerCards = new String[10];
		yourHandSize = 2;
		dealerHandSize = 1;
		yourCards[0] = Dealer.dealcard();
		yourCards[1] = Dealer.dealcard();
		dealerCards[0] = Dealer.dealcard();
		System.out.println( "Your cards are" + printCards(yourCards));
		System.out.println( "Dealer's cards are" + printCards(dealerCards) + " X");
		scoreTable = new ConcurrentHashMap<String, Integer>();
			scoreTable.put("2", 	2);
			scoreTable.put("3", 	3);
			scoreTable.put("4", 	4);
			scoreTable.put("5", 	5);
			scoreTable.put("6", 	6);
			scoreTable.put("7", 	7);
			scoreTable.put("8", 	8);
			scoreTable.put("9", 	9);
			scoreTable.put("10", 	10);
			scoreTable.put("J", 	10);
			scoreTable.put("Q", 	10);
			scoreTable.put("K", 	10);
			scoreTable.put("A", 	11);
		
		
	}
		
	
	public String printCards(String[] hand){
		String cards = "";
		for (int i = 0; hand[i] != null; i++) {
			cards = cards + " " + hand[i];
		}
		return cards;
	}
	
	public void hit(){
			yourCards[yourHandSize] = Dealer.dealcard();
			yourHandSize++;
	}
	
	public int getScore(String[] hand){
		int score = 0; 
		int count = 0;
		for (int i = 0; hand[i] != null; i++){
			score += scoreTable.get(hand[i]);
			if (hand[i].equals("A"))
				count++;
		}
		while (score > 21 && count > 0){
			score -= 10;
			count --;
		}
		return score;
	}
	
	public void ask(){
		String answer;
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to hit?");
		answer = input.next();
		if (answer.startsWith("Y") || answer.startsWith("y")){
			hit();
			System.out.println( "Your cards are" + printCards(yourCards));
			System.out.println( "Dealer's cards are" + printCards(dealerCards) + " X");
			int score = getScore(yourCards);
			System.out.println("Your score is " +score);
			if (score > 21){
				System.out.println("Bust!");
				checkScores();
				return;
			}
			ask();
		} else
			dealerGo();
	}
	
	public void dealerGo(){
		int score = getScore(dealerCards);
		while (score < 17){
			dealerCards[dealerHandSize] = Dealer.dealcard();
			dealerHandSize++;
			score = getScore(dealerCards);
			System.out.println( "Dealer's cards are" + printCards(dealerCards));
		}
	}
	
	public void checkScores(){
		if (getScore(yourCards) > 21) {
			System.out.println("You lose!");
			return;
		}else if (getScore(dealerCards) > 21) {
			System.out.println("You win!");
			return;
		}else if (getScore(yourCards) > getScore(dealerCards)) {
			System.out.println("You win!");
			return;
		}else if (getScore(yourCards) < getScore(dealerCards)){
			System.out.println("You lose!");
			return;
		}else{
			System.out.println("Draw!");
		}
	}
	

	
}
