package week3;

public class DDArray {

	public static void main(String[] args) {
		char[][] answers = {
				{'A', 'B', 'A', 'C', 'C'},
				{'A', 'C', 'A', 'E', 'A'},
				{'C', 'B', 'D', 'C', 'A'},
				{'D', 'B', 'D', 'D', 'E'},
				{'A', 'B', 'D', 'E', 'A'},
		};
		
		char[] key = {'A', 'C', 'D', 'E', 'A'};
		
		for(int i = 0; i < answers.length; i++) {
			int score = 0;
			
			for(int j = 0; j < answers[i].length; j++) {
				if(answers[i][j] == key[j]) {
					score++;
				}
			}
			
			System.out.println("Student " + (i+1) + " has " + score + " correct answers!");
		}
		
	}
}
