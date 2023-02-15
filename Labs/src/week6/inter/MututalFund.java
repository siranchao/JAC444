package week6.inter;

public class MututalFund extends ShareAsset {

	private double totalShares;
	
	public MututalFund(String symbol, double currentPrice) {
		super(symbol, currentPrice);
		totalShares = 0.0;
	}

	@Override
	public double getMarketValue() {
		return totalShares * getCurrentPrice();
	}

	@Override
	public double getProfit() {
		return getMarketValue() - getTotalCost();
	}

	public double getTotalShares() {
		return totalShares;
	}
	
	public void purchase(double shares, double pricePerShare) {
		totalShares += shares;
		addCost(shares * pricePerShare);
	}

}
