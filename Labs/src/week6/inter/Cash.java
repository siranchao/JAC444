package week6.inter;



public class Cash implements Asset {

	private double amount;
	
	public Cash(double amount) {
		this.amount = amount;
	}
	
	@Override
	public double getMarketValue() {
		return amount;
	}
	
	@Override
	public double getProfit() {
		return 0.0;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
