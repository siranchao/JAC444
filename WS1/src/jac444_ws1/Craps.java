package jac444_ws1;

/**This class create Craps game, the program act in single player to perform the dice game
 * 
 * @author Siran
 *
 */
import java.util.Scanner;
public class Craps {
	public int diceA;
	public int diceB;
	public int savePoint;
	private boolean cont;
	
	/**
	 * Default constructor setting two dices to 1;
	 */
	public Craps() {
		this.diceA = this.diceB = 1;
		this.savePoint = 0;
		this.cont = true;
		System.out.println("--- Craps Game Start! ---");
	}
	
	/**
	 * roll two dice one time randomly and return values
	 * @return sum of two dices
	 */
	public int roll() {
		this.diceA = (int)(Math.random() * 6) + 1;
		this.diceB = (int)(Math.random() * 6) + 1;
		int sum = this.diceA + this.diceB;
		
		System.out.println("You rolled " + this.diceA + " + " + this.diceB + " = " + sum);
		return sum;
	}
	
	/**
	 * this method check sum of each roll and print results based on game rules
	 * @param sum
	 */
	public void checkResult(int sum) {	
		//check result depends on if the game was saved
		if(this.savePoint == 0) {
			switch(sum) {
			case 2:
			case 3:
			case 12:
				System.out.println("Craps, Better Luck Next Time, You lose");
				this.cont = false;
				break;
			case 7:
			case 11:
				System.out.println("Congratulations, You win");
				this.cont = false;
				break;
			default:
				this.savePoint = sum;
				System.out.println("Point is (established) set to " + this.savePoint);
				break;
			}
		}
		else {
			if(sum == 7) {
				System.out.println("Craps, Better Luck Next Time, You lose");
				this.cont = false;
			}
			if(sum == this.savePoint) {
				System.out.println("Congratulations, You win");
				this.cont = false;
			}
		}
		
	}
	
	/**
	 * this is the main controller method of the game
	 */
	public void playGame() {
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.print("Press any key to roll the dice: ");
			if(scan.next().charAt(0) != ' ') {
				checkResult(roll());
			}
			
		} while(this.cont);
		
		resetGame();
		//scan.close();
	}
	
	/**
	 * reset the game and set saved point to 0
	 */
	public void resetGame() {
		this.savePoint = 0;
		this.cont = true;
		System.out.println("--- Craps Game Reset! ---");
	}
	
	
	public static void main(String[] args) {
		
		Craps newGame = new Craps();
		
		//play the game 4 times
		for(int i = 0; i < 4; i++) {
			System.out.println("GAME: " + (i+1));
			newGame.playGame();
		}
	}
}
