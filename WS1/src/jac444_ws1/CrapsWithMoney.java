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

import java.util.Scanner;

public class CrapsWithMoney extends Craps{
	
	private int balance;
	
	/**
	 * Default constructor setting balance to $1000;
	 */
	public CrapsWithMoney() {
		super();
		this.balance = 1000;
		System.out.println("Game start you balance is: $1000");
	}
	
	/**
	 * this method return the private member balance
	 * @return current balance 
	 */
	public int getBalance() {
		return this.balance;
	}
	
	/**
	 * this method specify playGame() with money involved
	 * @param scan input Scanner
	 */
	public void gamble(Scanner scan) {
		System.out.print("Please enter a wager(minimum $1): ");
		int bet = scan.nextInt();
		//Check balance
		while(bet > this.balance) {
			System.out.print("Insufficient balance (current: $" + this.balance + " ) " + "Please enter again: ");
			bet = scan.nextInt();
		}
		
		chatter();
		playGame(scan);
		
		if(this.result == 0) {
			this.balance -= bet;
			if(this.balance > 0) {
				System.out.println("Sorry you lose! New balance is: " + this.balance);
				chatter();
			}
			else {
				System.out.println("Sorry. You busted!");
			}
		}
		if(this.result == 1) {
			this.balance += bet;
			System.out.println("You win! New balace is: "+ this.balance);
			chatter();
		}
			
	}
	
	/**
	 * this method randomly generate and display chatters once been called 
	 */
	public void chatter() {
		String[] list = {
				"Take a shot and win big...",
				"Oh, you’re going for broke, huh?",
				"Aw c’mon, take a chance!",
				"You’re up big. Now’s the time to cash in your chips!",
		};
		
		String output = list[(int)(Math.random() * (list.length - 1))];
		System.out.println("\n" + output + "\n");
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		CrapsWithMoney newGame = new CrapsWithMoney();
		
		//keep playing as long as not broke
		while(newGame.getBalance() > 0) {
			newGame.gamble(scan);
		}
		
		System.out.println("\n" + "--- You game is over, bring more money next time ---" + "\n");
		
		scan.close();
	}

}
