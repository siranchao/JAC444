package week6.inter;

public class Stock extends ShareAsset{

	private int totalShares;
	
	public Stock(String symbol, double currentPrice) {
		super(symbol, currentPrice);
		totalShares = 0;
	}

	@Override
	public double getMarketValue() {
		return totalShares * getCurrentPrice();
	}

	@Override
	public double getProfit() {
		return getMarketValue() - getTotalCost();
	}
	
	public int getTotalShares() {
		return totalShares;
	}

	public void purchase(int shares, double pricePerShare) {
		totalShares += shares;
		addCost(shares * pricePerShare);
	}
}
