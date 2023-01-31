package week3;

public class PassingArrayValue {
	public static void main(String[] args) {
		int[] a = {1,2};
		int[] b = {3,4};
		
		/*b=a;//this is not making a copy for me.
		
		a[0] = 2;
		System.out.println(a[0]);
		System.out.println(b[2]);//show the exception */
		
		//this properly copying the elements
		/*for(int i=0; i<b.length; i++)
		{
			b[i] = a[i];
		}
		System.out.println(a);
		System.out.println(b);
		
		a[0]=2;
		System.out.println(a[0]+ " " + a[1]);//2
		System.out.println(b[0] + " " + b[1]);//1*/
		
		//this is also giving me proper copy of array elements.
		
		System.arraycopy(a, 0, b, 0, b.length);
		
		System.out.println(a);
		System.out.println(b);
		
		a[0]=2;
		System.out.println(a[0]+ " " + a[1]);//2
		System.out.println(b[0] + " " + b[1]);//1
		
		//making  a clone function
		
		System.out.println("Before invoking swap");
	    System.out.println("array is {" + a[0] + ", " + a[1] + "}");
	    swap(a[0], a[1]);
	    System.out.println("After invoking swap");
	    System.out.println("array is {" + a[0] + ", " + a[1] + "}");

	    // Swap elements using the swapFirstTwoInArray method
	    System.out.println("Before invoking swapFirstTwoInArray");
	    System.out.println("array is {" + a[0] + ", " + a[1] + "}");
	    swapFirstTwoInArray(a);
	    System.out.println("After invoking swapFirstTwoInArray");
	    System.out.println("array is {" + a[0] + ", " + a[1] + "}");
	    
	    for(int index : a)
	    {System.out.println(index);}
	    
	    int[][] dda = new int[3][3];
	    
	    int[][] arrd = {
	    		{1,2},{4,5,6,7},{8,9,10}
	    };
	    
	    System.out.println(arrd[0].length); //2
	    System.out.println(arrd[1].length); //4
	    System.out.println(arrd[2].length); //3
	  }

	  /** Swap two variables */
	  public static void swap(int n1, int n2) {
	    int temp = n1;
	    n1 = n2;
	    n2 = temp;
	  }

	  /** Swap the first two elements in the array */
	  public static void swapFirstTwoInArray(int[] array) {
	    int temp = array[0];
	    array[0] = array[1];
	    array[1] = temp;
	  }
}
