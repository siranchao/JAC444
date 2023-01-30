/**********************************************
Workshop 1
Course: JAC444
Last Name: CAO
First Name: Siran
ID: 159235209
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 01/29/2023
**********************************************/

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
	// result -1: pending, 1: win, 0: lose
	public int result;
	
	/**
	 * Default constructor setting two dices to 1;
	 */
	public Craps() {
		this.diceA = this.diceB = 1;
		this.savePoint = 0;
		this.result = -1;
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
	 * @param sum of each roll
	 */
	public void checkResult(int sum) {	
		
		
		//check result depends on if the game was saved
		if(this.savePoint == 0) {
			switch(sum) {
			case 2:
			case 3:
			case 12:
				System.out.println("Craps, Better Luck Next Time, You lose");
				this.result = 0;
				break;
			case 7:
			case 11:
				System.out.println("Congratulations, You win");
				this.result= 1;
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
				this.result = 0;
			}
			if(sum == this.savePoint) {
				System.out.println("Congratulations, You win");
				this.result = 1;
			}
		}
		
	}
	
	/**
	 * this is the main controller method of the game
	 * @param scan input Scanner
	 */
	public void playGame(Scanner scan) {
		
		do {
			System.out.print("Press any key to roll the dice: ");
			if(scan.next().charAt(0) != ' ') {
				checkResult(roll());
			}
			
		} while(this.result == -1);
		
	}
	
	
	/**
	 * reset the game and set saved point to 0
	 */
	public void resetGame() {
		this.savePoint = 0;
		this.result = -1;
		System.out.println("--- Craps Game Reset! ---");
	}
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Craps newGame = new Craps();
		
		//play the game 4 times
		for(int i = 0; i < 4; i++) {
			System.out.println("GAME: " + (i+1));
			newGame.playGame(scan);
			newGame.resetGame();
			scan.nextLine();
		}
		
		scan.close();
	}
}
