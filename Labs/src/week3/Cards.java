package week3;

public class Cards {
	
	public static void main(String[] args) {
		int[] deck = new int[52];
		
		String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
		String[] ranks = {"J", "Q", "K", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		
		//initial card order
		for(int i = 0; i < deck.length; i++) {
			deck[i] = i;
		}
		
		//Shuffle cards
		for(int i = 0; i < deck.length; i++) {
			int index = (int)(Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
		
		//random draw 4 cards
		for(int i = 0; i < 4; i++) {
			String suit = suits[deck[i] / 13];
			String rank = ranks[deck[i] % 13];
			
			System.out.println("Card number " + deck[i] + ": " + suit + " " + rank);
		}
		
	}

}
