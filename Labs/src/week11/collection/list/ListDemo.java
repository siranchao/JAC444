package week11.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {

	public static void main(String[] args) {
		//responisbility of the compiler
		List<String> list = new ArrayList<>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("3");
		list.add("3");
		list.add(null);
		
		System.out.println(list);
		
		list.remove(3);
		System.out.println(list);
		
		list.remove("3");
		System.out.println(list);
		
		for(String a : list)
			System.out.println(a);
		
		//raw type list are programmer responsibilty 
		List list1 = new ArrayList();
		list1.add(1);
		list1.add("abc");
		list1.add(22.35);
		
		List<Integer> listint = new ArrayList<>();
		
		listint.add(1);
		listint.add(2);
		listint.add(3);
		listint.add(4);
		listint.add(5);
		
		List<Integer> subList = listint.subList(1, 4);
		System.out.println(subList);
		
		listint.set(1, 10);
		System.out.println(subList);
		//listint.add(0,10);
		//System.out.println(subList);
		
		/*for(int e : listint) {
			System.out.print(e + " ");
			if(e == 10)
				listint.remove(Integer.valueOf(e));
		}*/
		
		Iterator<Integer> iter = listint.iterator();
		while(iter.hasNext()) {
			int e = iter.next();
			
			System.out.print(e + " ");
			if(e == 10)
				iter.remove();
		}
		System.out.println(listint);
		
		
		String[]  color1 = {"black","yellow","green","blue","red"};
		List<String> c1 = new LinkedList<>();
		
		for(String c : color1)
			c1.add(c);
		
		System.out.println(c1);
		
		ListIterator<String> itl = c1.listIterator(c1.size());
		
		while(itl.hasPrevious())
			System.out.print(itl.previous() + " ");
	}
}
