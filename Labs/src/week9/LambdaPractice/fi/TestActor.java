package week9.LambdaPractice.fi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class TestActor {

	public static void main(String...strings) {
		Actors john = new Actors("John Doe", 30);
		Actors snow = new Actors("Snow White", 22);
		Actors bill = new Actors("Kill Bill", 40);
		Actors jack = new Actors("Jack Jill", 21);
		
		List<Actors> actorss = new ArrayList<>();
		actorss.add(john);
		actorss.add(snow);
		actorss.add(bill);
		actorss.add(jack);
		System.out.println("Before sorting");
		for(Actors a : actorss) {
			
			System.out.println(a.getName());
		}
	
		Collections.sort(actorss, /*new Comparator<Actors>() {

			@Override
			public int compare(Actors o1, Actors o2) {
				
				return o1.getName().compareTo(o2.getName());
			}*/
				( a1 , a2)-> a1.getName().compareTo(a2.getName()));
			
		
		System.out.println("After sorting");
		for(Actors a : actorss)
			System.out.println(a.getName());
		
		String someString = doStringStuff(/*new UpperConcat() {
			@Override
			public String upperAndConcat(String s1, String s2) {
				return s1.toUpperCase() +" "  + s2.toUpperCase();
			}*/
		 (s1,s2)->s1.toUpperCase() + " " + s2.toUpperCase(), actorss.get(0).getName(), actorss.get(1).getName());
		
		System.out.println(someString);
		System.out.println("foreach loop printing now");
		System.out.println();
		actorss.forEach(a -> {
			System.out.print(a.getName()+":");
			System.out.println(a.getAge());
		});
		
		Actors red = new Actors("Red RdiginHood", 35);
		Actors charming = new Actors("Prince Charming", 38);
		actorss.add(red);
		actorss.add(charming);
		
		System.out.println("Actors over 30");
		System.out.println("==================");
		/*for(Actors a : actorss) {
			if(a.getAge() > 30) {
				System.out.println(a.getName());
			}
		}*/
		actorss.forEach(a->{
					if(a.getAge() > 30)
						System.out.println(a.getName());
				});
		
		System.out.println("Actors over 30 and younger");
		System.out.println("===========================");
	
		actorss.forEach(a->{
					if(a.getAge() <= 30)
						System.out.println(a.getName());
				});
		System.out.println();
		System.out.println();
		printActorsByAge(actorss,"Actors over 30", a -> a.getAge() > 30);
		printActorsByAge(actorss,"Actors 30 and Under", a -> a.getAge() <= 30);
		
		IntPredicate greaterThan15 = i-> i > 15;
		IntPredicate lessThan100 = i-> i < 100;
		int a = 20;
		System.out.println(greaterThan15.test(10+a));
		
		System.out.println(greaterThan15.and(lessThan100).test(50));
		
	}
	
	private static void printActorsByAge(List<Actors> actrs, 
											String ageText, 
											Predicate<Actors> ageCondition ) {
		System.out.println(ageText);
		System.out.println("=====================");
		for(Actors a : actrs) {
			if(ageCondition.test(a)) {
				System.out.println(a.getName());
			}
		}
	}
	public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
		return uc.upperAndConcat(s1, s2);
	}
	
}
