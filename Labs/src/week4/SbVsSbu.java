package week4;

public class SbVsSbu {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		StringBuffer sb = new StringBuffer("hello");
		for(int i=0; i<10000; i++)
			sb.append(" World");
		System.out.println("Time taken by SBUffer " + (System.currentTimeMillis() - startTime) + " ms");
		
		 startTime = System.currentTimeMillis();
		
		StringBuilder sbl = new StringBuilder("hello");
		for(int i=0; i<10000; i++)
			sbl.append(" World");
		System.out.println("Time taken by SBuilder " + (System.currentTimeMillis() - startTime) + " ms");
	}

}
