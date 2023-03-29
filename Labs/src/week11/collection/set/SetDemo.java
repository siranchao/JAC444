package week11.collection.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> s1 = new HashSet<>();
		s1.add("A");
		s1.add("B");
		s1.add("C");
		s1.add("D");
		s1.add("A");
		System.out.println(s1);

		Set<Book> sb = new HashSet<>();
		
		Book b1 = new Book("Harry Potter", "Some Author" , 1999);
		Book b2 = new Book("Harry Potter", "Some Author" , 1999);
		Book b3 = new Book("Walden", "Another Author" , 2001);
		Book b4 = new Book("Effective Language", "E Author" , 1954);
		
		sb.add(b1);
		sb.add(b2);
		
		System.out.println(sb);
		
		Set<String> sbt = new TreeSet<>();
		sbt.add("Putera");
		sbt.add("Jonathan");
		sbt.add("Bikash");
		System.out.println(sbt);
		
		Set<Book> sbtb = new TreeSet<>(new Title());
		sbtb.add(b1);
		sbtb.add(b2);
		sbtb.add(b3);
		sbtb.add(b4);
		System.out.println(sbtb);
	}

}
