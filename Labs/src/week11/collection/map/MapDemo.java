package week11.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		Map<String, Integer> m1 = new HashMap<>();
		m1.put("John", 25);
		m1.put("Kyle", 35);
		m1.put("Carol", null);
		
		System.out.println(m1);
		m1.put("Carol", 45);
		System.out.println(m1);
		System.out.println("The age of Kyle " + m1.get("Kyle"));
		Set<String> keyset = m1.keySet();
		for(String s : keyset)
			System.out.println("The age is " + s + ":" + m1.get(s));
		
		//i want to create userProfile
		Map<String, Map<String, Object>> userProfile = new HashMap<>();
		
		Map<String, Object> jpp = new HashMap<>();
		jpp.put("age", 1);
		jpp.put("dept", "CS");
		jpp.put("city", "Markham");
		
		userProfile.put("John", jpp);
		
		Map<String, Object> kpp = new HashMap<>();
		kpp.put("age", 10);
		kpp.put("dept", "History");
		kpp.put("city", "Toronto");
		
		userProfile.put("Kyle", kpp);
		
		System.out.println(userProfile);
		
	}
}
