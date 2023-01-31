package week4;

public class StringExample {

	public static void main(String[] args) {
		
		String s = new String();			//Not a good option
		s = "World";
		String s1 = new String("Hello");	//Not a good option
		String s4 = new String ("Hello");

		char[] ca = {'N','A','M','E'};
		String s2 = new String(ca);			//Not a good option
		
		String s3 = "Hello World";	//String literals	//best option available
		String s5 = "Hello World";
		s3 = "By";
		
		System.out.println(s1 == s4); //false
		System.out.println(s3 == s5); //true
		System.out.println(s1);
		System.out.println(s4);
		System.out.println(s3);
		System.out.println(s5);
		
		
		//literal
		int i = 6;
		
		Integer ai = i;
		System.out.println(ai);
		
		String s6 = "Flower";
		System.out.println(s6.concat(" Andy"));
		s6 = s6.concat(" Flowlr");
		
		System.out.println(s6);
		//System.out.println(s7);
		
		System.out.println(s6.length());
		System.out.println(s6.isEmpty());
		
		System.out.println(s6.equals("flower flower"));
		System.out.println(s6.equalsIgnoreCase("flower flower"));
		System.out.println(s6.compareTo("Flower Flower"));
		
		System.out.println(s6.contains("l"));
		System.out.println(s6.indexOf("l"));
		System.out.println(s6.lastIndexOf("l"));
		
		String s7 = s6.substring(0, 6);
		System.out.println(s7);
		
		String[] s8 = s6.split(s7,3);
		for(String temp:s8)
			System.out.println(temp);
		
		
		String s9 = String.valueOf(i);
		System.out.println(s9);
		
		StringBuilder sb = new StringBuilder("Hello");
		System.out.println(sb);
		sb.append(" World");
		System.out.println(sb);
		System.out.println(sb.reverse());
		
		StringBuilder sb1 = new StringBuilder("sfsdfd");
		
		StringBuffer sbf = new StringBuffer("Random String");
		
		
		
	}

}
