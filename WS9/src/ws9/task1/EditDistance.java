package ws9.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class EditDistance {
	
	private List<String> words = new ArrayList<>();;
	private Map<String, List<String>> neighborMap = new HashMap<>();

	
	/**
	 * this method read the file inputs into arrayList and call computeMap to create a Hashmap
	 * @param fileName
	 */
	public void readDict (String fileName) {
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line;
			while((line = br.readLine()) != null) {
				words.add(line);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		computeMap();
	}
	
	
	/**
	 * this method compute a map from each work pair to any its immediate neighbors
	 */
	private void computeMap() {
		for(String word: words) {
			List<String> neighbors = new ArrayList<>();
			
			//scan each neighbors for each word
			for(String other : words) {
				if(oneEditDistance(word, other)) {
					neighbors.add(other);
				}
			}
			
			//add word-neighbors pair to map
			neighborMap.put(word, neighbors);
		}
	}


	/**
	 * this method check if the two words has only 1 edit distance
	 * @param word1
	 * @param word2
	 * @return check result T/F
	 */
	private boolean oneEditDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		if(Math.abs(m - n) > 1) {
			return false;
		}
	
		//scan each word char by char
		int i = 0, j = 0, count = 0;
		while(i < m && j < n) {
			if(word1.charAt(i) == word2.charAt(j)) {
				i++;
				j++;
			}
			else {
				count++;
				if (count > 1) {
					return false;
				}
				if(m == n) {
					i++;
					j++;
				} else if(m > n) {
					i++;
				} else {
					j++;
				}
			}
		}
		if(i < m || j < n) {
			count++;
		}
		
		return count == 1;
	}


	/**
	 * this method receives a start and a end word, calculate the edit distance between two words
	 * @param start
	 * @param end
	 */
	public void calcEditDistance(String start, String end) {
		LinkedList<String> visited = new LinkedList<>();
		Set<String> path = new HashSet<>();
		Map<String, String> pathMap = new HashMap<>();
		
		visited.add(start);
		path.add(start);

		//iterating visited list
		while(!visited.isEmpty()) {
			String word = visited.remove();
			
			//loop over all neighboring words
			for(String neighbor : neighborMap.get(word)) {
				if(!path.contains(neighbor)) {
					visited.add(neighbor);
					//add to path set, no duplicate
					path.add(neighbor);
					
					pathMap.put(neighbor, word);
					
					if(neighbor.equals(end)) {
						//find and display the shortest path
						printPath(pathMap, start, end);
						
						//show pathMap
//						for (Map.Entry<String, String> entry : pathMap.entrySet()) {
//					        String key = entry.getKey();
//					        String value = entry.getValue();
//					        System.out.println(key + "---" + value);
//					    }					
						return;
					}
				}
			}
		}
		
		//No path exist
		System.out.println("No path exists from " + start  + "to" + end);
	}

	
	
	/**
	 * this method will convert the pathMap to find out the shortest path
	 * @param pathMap 
	 * @param start 
	 * @param end
	 */
	private void printPath(Map<String, String> pathMap, String start, String end) {
        List<String> path = new ArrayList<>();
        String current = end;
        while (!current.equals(start)) {
            path.add(0, current);
            current = pathMap.get(current);
        }
        path.add(0, start);
        
        System.out.println("Edit distance = " + (path.size() - 1));
        System.out.println("The shortest path is: " + String.join(" -> ", path) + "\n");
    }
	
	
	
	/**
	 * this method check if the hashmap contains the given word
	 * @param word
	 * @return
	 */
	public boolean checkWord(String word) {
		return neighborMap.containsKey(word);
	}
	
	
	
	/**
	 * this method iterate and display all value in the map, for test only
	 */
	public void mapIteration() {
		//iterate the map
		for (Map.Entry<String, List<String>> entry : neighborMap.entrySet()) {
	        String key = entry.getKey();
	        List<String> value = entry.getValue();
	        System.out.println(key + "---" + value);
	    }
	}
	
	
}
