package StatsLibrary;

import java.math.BigInteger;
import java.util.Arrays;

public class StatsLibrary {
	
	/**
	 * Find the median of a list
	 * @param input The list to find the median of
	 * @return The median of the list
	 */
	public static double findMean(double[] input) {
		double sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum+=input[i];
		}
		return sum/(double)input.length;
	}
	
	/**
	 * Find the median of a list
	 * @param input The list to find the median of
	 * @return The median of the list
	 */
	public static double findMedian(double[] input) {
		Arrays.sort(input);
		if (input.length % 2 == 0) {
			double[] temp = new double[2];
			temp[0] = input[input.length/2-1];
			temp[1] = input[(input.length/2)];
			return findMean(temp);
		} else {
			return input[input.length/2];
		}
	}
	
	/**
	 * Find the mode of a list
	 * @param input The list to find the mode of
	 * @return The mode of the list
	 */
	public static double findMode(double[] input) {
		Arrays.sort(input);
		double mostNumbers = 0;
		double currentCount = 0;
		double highestCount = 0;
		double latestNumber = Double.MAX_VALUE;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == latestNumber) {
				currentCount++;
			} else {
				currentCount = 0;
			}
			if (currentCount < highestCount) {
				highestCount = currentCount;
				mostNumbers = input[i];
			}
		}
		return mostNumbers;
	}
	
	/**
	 * Find the standard deviation of a list
	 * @param input The list to find the standard deviation of
	 * @return The standard deviation
	 */
	public static double stDev(double[] input) {
		double sum = 0;
		double mean;
		for (int i = 0; i < input.length; i++) {
			sum+= input[i];
		}
		mean = sum/input.length;
		sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += Math.pow(mean-input[i], 2);
		}
		return Math.sqrt(sum/(input.length-1));
	}
	
	/**
	 * A method to find the factorial of a number
	 * @param num The number to find the factorial of
	 * @return The factorial of the input
	 */
	public static BigInteger factorial(int num) {
		BigInteger product = new BigInteger("1");
		if (num == 0) return product;
		for (Integer i = 1; i <= num; i++) {
			product = product.multiply(new BigInteger(i.toString()));
		}
		return product;
	}
	
	/**
	 * A method to find number of arrangements of r objects with n orders
	 * @param r The number of objects
	 * @param n The number of orders
	 * @return The permutation of r and n
	 */
	public static BigInteger permutation(int r, int n) {
		BigInteger numerator = factorial(n);
		BigInteger denominator = factorial(n-r);
		return numerator.divide(denominator);
	}
	
	/**
	 * A method to find the combination of 2 numbers
	 * @param r The size of the subsets
	 * @param n The number of objects
	 * @return r choose n
	 */
	public static BigInteger combination(int r, int n) {
		return permutation(r, n).divide(factorial(r));
	}
	
	/**
	 * A method to find the dependent P(A∩B)
	 * @param a A
	 * @param b B
	 * @param probabilityOfAGivenB P(A|B)
	 * @return P(A∩B)
	 */
	public static double probabilityOfAIntersectB(double a, double b, double probabilityOfAGivenB) {
		return b*probabilityOfAGivenB;
	}
	
	/**
	 * A method to find the independent P(A∩B)
	 * @param a A
	 * @param b B
	 * @return P(A∩B)
	 */
	public static double probabilityOfAIntersectB(double a, double b) {
		return a*b;
	}
	
	/**
	 * A method to find P(A|B)
	 * @param a A
	 * @param b B
	 * @param probabilityOfAIntersectB P(A∩B)
	 * @return P(A|B)
	 */
	public static double probabilityOfAGivenB(double a, double b, double probabilityOfAIntersectB) {
		return probabilityOfAIntersectB/b;
	}
	
	/**
	 * A method to find dependent P(A∪B)
	 * @param a A
	 * @param b B
	 * @return P(A∪B)
	 */
	public static double probabilityOfAUnionB(double a, double b) {
		return a+b;
	}
	
	/**
	 * A method to find dependent P(A∪B)
	 * @param a
	 * @param b
	 * @return P(A∪B)
	 */
	public static double probabilityOfAUnionB(double a, double b, double probabilityOfAGivenB) {
		return a+b-probabilityOfAIntersectB(a, b, probabilityOfAGivenB);
	}
	
	/**
	 * Bayes Theorem to get P(B|A)
	 * @param a A
	 * @param b B
	 * @param probabilityOfAIntersectB P(A|B)
	 * @return P(B|A)
	 */
	public static double probabilityOfBGivenA(double b, double a, double probabilityOfAIntersectB) {
		return (probabilityOfAGivenB(a, b, probabilityOfAIntersectB)*b)/a;
	}
	
	/**
	 * Binomial Distribution
	 * @param x The target number of successes
	 * @param p Probability of success
	 * @param n The number of trials
	 * @return The Binomial Distribution
	 */
	public static double binomialDistribution(int x, double p, int n) {
		return combination(n, x).doubleValue()*Math.pow(p, x)*Math.pow(1-p, n-x);
	}
	
	/**
	 * Geometric Distribution
	 * @param x The trial number of the first success
	 * @param p The probability of success in each trial
	 * @return The Geometric Distribution
	 */
	public static double geometricDistribution(int x, double p) {
	    return Math.pow(1-p, x-1)*p;
	}

	/**
	 * Hypergeometric Distribution
	 * @param N The total population size
	 * @param K The number of success states in the population
	 * @param n The number of draws
	 * @param x The number of observed successes
	 * @return The Hypergeometric Distribution
	 */
	public static double hypergeometricDistribution(int N, int K, int n, int x) {
	    return combination(x, K).multiply(combination(n-x, N-K)).doubleValue()/combination(n, N).doubleValue();
	}

	/**
	 * Negative Binomial Distribution
	 * @param x The total number of trials
	 * @param r The number of required successes
	 * @param p The probability of success in each trial
	 * @return The Negative Binomial Distribution
	 */
	public static double negativeBinomialDistribution(int x, int r, double p) {
	    return combination(r-1, x-1).doubleValue()*Math.pow(p, r)*Math.pow(1-p, x-r);
	}

}
