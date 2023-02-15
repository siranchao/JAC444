package week6.inter;

public abstract class ShareAsset implements Asset{

	private String symbol;
	private double totalCost;
	private double currentPrice;
	
	public ShareAsset(String symbol, double currentPrice) {
		this.currentPrice = currentPrice;
		this.symbol = symbol;
		totalCost = 0.0;
	}
	
	public void addCost(double cost) {
		totalCost += cost;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getSymbol() {
		return symbol;
	}

	public double getTotalCost() {
		return totalCost;
	}

	
	public abstract double getMarketValue() ;

	@Override
	public double getProfit() {
		return getMarketValue() - totalCost;
	}
	
	
}
