package StatsLibrary;

public class Tester {
    public static void main(String[] args) {
        double[] testList = {10, 20, 30, 40, 50, 20, 30, 30};

        // Run tests
        System.out.println("Mean: " + StatsLibrary.findMean(testList)); // Expected: ~28.75
        System.out.println("Median: " + StatsLibrary.findMedian(testList)); // Expected: 30.0
        System.out.println("Mode: " + StatsLibrary.findMode(testList)); // Expected: 30.0
        System.out.println("StDev: " + StatsLibrary.stDev(testList)); // Expected: ~12.5
        System.out.println("5!: " + StatsLibrary.factorial(5)); // Expected: 120
        System.out.println("P(5,3): " + StatsLibrary.permutation(3, 5)); // Expected: 60
        System.out.println("C(5,3): " + StatsLibrary.combination(3, 5)); // Expected: 10
        System.out.println("P(A ∩ B): " + StatsLibrary.probabilityOfAIntersectB(0.3, 0.5)); // Expected: 0.15
        System.out.println("P(A ∩ B): " + StatsLibrary.probabilityOfAIntersectB(0.3, 0.5, 0.7)); // Expected: 0.35
        System.out.println("P(A | B): " + StatsLibrary.probabilityOfAGivenB(0.3, 0.5, 0.2)); // Expected: 0.4
        System.out.println("P(A ∪ B): " + StatsLibrary.probabilityOfAUnionB(0.3, 0.5)); // Expected: 0.8
        System.out.println("P(A ∪ B): " + StatsLibrary.probabilityOfAUnionB(0.3, 0.5, 0.7)); // Expected: 0.65
        System.out.println("Bayes' Theorem: " + StatsLibrary.probabilityOfBGivenA(0.5, 0.3, 0.2)); // Expected: 0.333
        System.out.println("Binomial Distribution: " + StatsLibrary.binomialDistribution(2, 0.5, 4)); // Expected: ~0.375
        System.out.println("Geometric Distribution: " + StatsLibrary.geometricDistribution(3, 0.5)); // Expected: 0.125
        System.out.println("Hypergeometric Distribution: " + StatsLibrary.hypergeometricDistribution(10, 5, 4, 2)); // Expected: ~0.476
        System.out.println("Negative Binomial Distribution: " + StatsLibrary.negativeBinomialDistribution(3, 2, 0.5)); // Expected: 0.25
    }
}
