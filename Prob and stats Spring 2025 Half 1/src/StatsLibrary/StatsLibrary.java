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
			double[] temp = new double[1];
			temp[0] = input[input.length/2];
			temp[1] = input[1+(input.length/2)];
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
		for (Integer i = 0; i < num; i++) {
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
	 * @return
	 */
	public double binomialDistribution(int x, double p, int n) {
		return combination(n, x).doubleValue()*Math.pow(p, x)*Math.pow(1-p, n-x);
	}
}
