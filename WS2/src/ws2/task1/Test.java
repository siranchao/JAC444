package ws2.task1;

public class Test {
	
	
	
	public static void main(String[] args) {
		
		SlipGenerator mockData = new SlipGenerator(30);
		
		mockData.generateData();
		
		Dashboard dashboard = new Dashboard();
		
		dashboard.convert(mockData.pool);
		
		dashboard.display();
		
	}

}
