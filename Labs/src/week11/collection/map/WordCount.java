package week11.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordCount {

	public static void main(String[] args) {
		Map<String, Integer> myMap = new HashMap<>();
		
		createMap(myMap);
		displayMap(myMap);
	}
	
	private static void createMap(Map<String, Integer> map) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string : ");
		String input = scan.nextLine();
		
		String[] token = input.split(" ");
		for(String t : token) {
			String word = t.toLowerCase();
			
			if(map.containsKey(word)) {
				int count = map.get(word);
				map.put(word, count+1);
			}
			else
				map.put(word, 1);
		}
	}
	
	private static void displayMap(Map<String, Integer> map) {
		Set<String> keys = map.keySet();
		
		TreeSet<String> sortedKeys = new TreeSet<>(keys);
		
		for(String k : sortedKeys) {
			System.out.print(k + " " + map.get(k));
		System.out.println();}
		System.out.println(map.size());
	}
}
