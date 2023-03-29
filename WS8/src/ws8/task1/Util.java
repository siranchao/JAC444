package ws8.task1;

public class Util {
	
	public static final DoubleArrayFunctions findMax = (double[] array) -> {
		double max = Double.NEGATIVE_INFINITY;
		for(double e : array) {
			if (e > max)
				max = e;
		}
		return max;
	};
	
	
	public static final DoubleArrayFunctions findMin = (double[] array) -> {
		double min = Double.POSITIVE_INFINITY;
		for(double e : array) {
			if(e < min)
				min = e;
		}
		return min;
	};
	
	
	public static final DoubleArrayFunctions findSum = (double[] array) -> {
		double sum = 0.0;
		for(double e : array) {
			sum += e;
		}
		return sum;
	};
	
	
	public static final DoubleArrayFunctions findAvg = (double[] array) -> {
		double sum = 0.0;
		for(double e : array) {
			sum += e;
		}
		return (sum / array.length);
	};

	
	public static DoubleArrayFunctions counter(double value) {
		return (double[] array) -> {
			double count = 0;
			for(double e : array) {
				if(e == value)
					count++;
			}
			return count;
		};
	}
	
	
}
