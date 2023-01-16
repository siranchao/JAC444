package SampleCode;

public class CalcPopulation {
	public static final int yearDays = 365;
	
	public static void main(String[] args) {
		int total = 312032486;
		int startYear = 2022;
		int seconds = 60*60*24*yearDays;
		
		for(int i = 0; i <= 5; i++) {
			System.out.println("Population in " + startYear + " is: " + total);
			
			total += seconds/7 + seconds/45 - seconds/13;
			startYear ++;
		}
		
	}
	
}
