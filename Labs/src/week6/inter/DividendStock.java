package week6.inter;

public class DividendStock extends Stock{

	private double dividends;
	
	public DividendStock(String symbol, double currentPrice) {
		super(symbol, currentPrice);
		dividends = 0.0;
	}

	@Override
	public double getMarketValue() {
		return super.getMarketValue() + dividends;
	}
	
	public void payDividends(double amountPerShare) {
		dividends += amountPerShare * getTotalShares();
	}
}
