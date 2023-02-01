package week3;

public class StaticVar {
	static String school= "Seneca";
	static int code = 113;
	String name;
	int age;
	
	public static void change() {
		school = "GARBA";
		code = 333;
	}
	
	StaticVar(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	
	public void print() {
		System.out.println("School: " + school);
		System.out.println("Code: " + code);
		System.out.println("NAME: " + this.name);
		System.out.println("AGE: " + this.age);
	}
	
	public void changeSatic() {
		school = "GARNBAGE";
		code = 444;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("school: " + StaticVar.school);
		
		StaticVar obj = new StaticVar("siarn", 32);
		
		obj.print();
		
		obj.changeSatic();
		obj.print();
		
		
	}
	
	

}
