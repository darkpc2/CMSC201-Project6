/*
 * Class: CMSC201 20809
 * Instructor: Grigoriy Grinberg
 * JUnit test class to test the isPrime method from
 * PrimeNumberMethod class (Listing 6.7). This program 
 * validates the functionality of the isPrime method with 
 * comprehensive test cases including edge cases, prime numbers,
 * composite numbers, and boundary conditions.
 * Due: 15 Dec 2025
 * Platform: Eclipse IDE / Java 8+
 * I pledge that I have completed the programming assignment independently.
 *    I have not copied the code from a student or any source.
 *    I have not given my code to any student.
 *    Print your Name here: Christian Canales
 */


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;

/**
 * JUnit test class for testing the isPrime method from PrimeNumberMethod.
 * This class contains comprehensive test methods to verify the correctness
 * of prime number detection for various input values including edge cases,
 * small primes, large primes, composite numbers, and special cases.
 * 
 * @author Christian Canales
 * @version 1.0
 * @since 2025-12-08
 */
public class PrimeNumberMethodTest {

    /**
     * Default constructor for PrimeNumberMethodTest class.
     * This constructor is used by JUnit to create test instances.
     */
    public PrimeNumberMethodTest() {
        // Default constructor
    }

    /**
     * Executes once before all tests.
     * Prints header information to console.
     */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("=========================================");
        System.out.println("Starting PrimeNumberMethodTest JUnit Tests");
        System.out.println("Testing isPrime() method from PrimeNumberMethod class");
        System.out.println("=========================================\n");
    }

    /**
     * Executes before each test method.
     * Prints which test is about to run.
     */
    @Before
    public void setUp() {
        System.out.println("Executing test...");
    }

    /**
     * Executes after each test method.
     * Prints completion message.
     */
    @After
    public void tearDown() {
        System.out.println("Test completed successfully.\n");
    }

    /**
     * Executes once after all tests.
     * Prints summary information.
     */
    @AfterClass
    public static void tearDownClass() {
        System.out.println("=========================================");
        System.out.println("All PrimeNumberMethodTest tests completed!");
        System.out.println("=========================================");
    }

    /**
     * Tests the isPrime method with small prime numbers.
     * Verifies that the method correctly identifies 2, 3, 5, and 7
     * as prime numbers. These are the first four prime numbers.
     */
    @Test
    public void testSmallPrimeNumbers() {
        System.out.println("Testing small prime numbers:");
        assertTrue("2 should be prime (smallest prime)", 
                   PrimeNumberMethod.isPrime(2));
        System.out.println("  ✓ isPrime(2) = true");
        assertTrue("3 should be prime", 
                   PrimeNumberMethod.isPrime(3));
        System.out.println("  ✓ isPrime(3) = true");
        assertTrue("5 should be prime", 
                   PrimeNumberMethod.isPrime(5));
        System.out.println("  ✓ isPrime(5) = true");
        assertTrue("7 should be prime", 
                   PrimeNumberMethod.isPrime(7));
        System.out.println("  ✓ isPrime(7) = true");
    }

    /**
     * Tests the isPrime method with larger prime numbers.
     * Verifies that the method correctly identifies various
     * larger prime numbers up to 97.
     */
    @Test
    public void testLargePrimeNumbers() {
        System.out.println("Testing larger prime numbers:");
        int[] primes = {11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 97};
        for (int prime : primes) {
            assertTrue(prime + " should be prime", 
                       PrimeNumberMethod.isPrime(prime));
            System.out.println("  ✓ isPrime(" + prime + ") = true");
        }
    }

    /**
     * Tests the isPrime method with composite numbers.
     * Verifies that the method correctly identifies non-prime
     * numbers (composite numbers) as false.
     */
    @Test
    public void testCompositeNumbers() {
        System.out.println("Testing composite (non-prime) numbers:");
        int[] composites = {4, 6, 8, 9, 10, 12, 15, 100};
        for (int composite : composites) {
            assertFalse(composite + " should not be prime", 
                        PrimeNumberMethod.isPrime(composite));
            System.out.println("  ✓ isPrime(" + composite + ") = false");
        }
    }

    /**
     * Tests the isPrime method with edge cases.
     * Verifies that the method correctly handles special cases
     * like 0, 1, and negative numbers which are not prime by definition.
     */
    @Test
    public void testEdgeCases() {
        System.out.println("Testing edge cases (0, 1, negative numbers):");
        assertFalse("0 should not be prime", 
                    PrimeNumberMethod.isPrime(0));
        System.out.println("  ✓ isPrime(0) = false");
        assertFalse("1 should not be prime (by definition)", 
                    PrimeNumberMethod.isPrime(1));
        System.out.println("  ✓ isPrime(1) = false");
        assertFalse("Negative numbers should not be prime (-5)", 
                    PrimeNumberMethod.isPrime(-5));
        System.out.println("  ✓ isPrime(-5) = false");
        assertFalse("-1 should not be prime", 
                    PrimeNumberMethod.isPrime(-1));
        System.out.println("  ✓ isPrime(-1) = false");
        assertFalse("-10 should not be prime", 
                    PrimeNumberMethod.isPrime(-10));
        System.out.println("  ✓ isPrime(-10) = false");
    }

    /**
     * Tests the isPrime method with perfect squares.
     * Verifies that the method correctly identifies perfect squares
     * (which are always composite except 1) as non-prime.
     * Perfect squares have at least three factors.
     */
    @Test
    public void testPerfectSquares() {
        System.out.println("Testing perfect squares:");
        int[] squares = {4, 9, 16, 25, 49, 64, 81, 121};
        for (int square : squares) {
            assertFalse(square + " should not be prime", 
                        PrimeNumberMethod.isPrime(square));
            System.out.println("  ✓ isPrime(" + square + ") = false");
        }
    }

    /**
     * Tests the isPrime method with even numbers.
     * Verifies that all even numbers (except 2) are correctly
     * identified as non-prime. 2 is the only even prime number.
     */
    @Test
    public void testEvenNumbers() {
        System.out.println("Testing even numbers:");
        assertTrue("2 is the only even prime number", 
                   PrimeNumberMethod.isPrime(2));
        System.out.println("  ✓ isPrime(2) = true (only even prime)");
        
        int[] evenNonPrimes = {4, 6, 20, 50, 100, 1000};
        for (int even : evenNonPrimes) {
            assertFalse(even + " should not be prime", 
                        PrimeNumberMethod.isPrime(even));
            System.out.println("  ✓ isPrime(" + even + ") = false");
        }
    }

    /**
     * Tests the isPrime method with consecutive numbers.
     * Verifies the method correctly distinguishes between
     * consecutive prime and non-prime numbers. This tests
     * the accuracy of the algorithm with numbers close together.
     */
    @Test
    public void testConsecutiveNumbers() {
        System.out.println("Testing consecutive numbers:");
        // Test sequence around 10
        assertFalse("10 should not be prime", 
                    PrimeNumberMethod.isPrime(10));
        System.out.println("  ✓ isPrime(10) = false");
        assertTrue("11 should be prime", 
                   PrimeNumberMethod.isPrime(11));
        System.out.println("  ✓ isPrime(11) = true");
        assertFalse("12 should not be prime", 
                    PrimeNumberMethod.isPrime(12));
        System.out.println("  ✓ isPrime(12) = false");
        assertTrue("13 should be prime", 
                   PrimeNumberMethod.isPrime(13));
        System.out.println("  ✓ isPrime(13) = true");
        assertFalse("14 should not be prime", 
                    PrimeNumberMethod.isPrime(14));
        System.out.println("  ✓ isPrime(14) = false");
        assertFalse("15 should not be prime", 
                    PrimeNumberMethod.isPrime(15));
        System.out.println("  ✓ isPrime(15) = false");
        
        // Test sequence around 20
        assertFalse("20 should not be prime", 
                    PrimeNumberMethod.isPrime(20));
        System.out.println("  ✓ isPrime(20) = false");
        assertFalse("21 should not be prime", 
                    PrimeNumberMethod.isPrime(21));
        System.out.println("  ✓ isPrime(21) = false");
        assertFalse("22 should not be prime", 
                    PrimeNumberMethod.isPrime(22));
        System.out.println("  ✓ isPrime(22) = false");
        assertTrue("23 should be prime", 
                   PrimeNumberMethod.isPrime(23));
        System.out.println("  ✓ isPrime(23) = true");
    }

    /**
     * Tests the isPrime method with numbers that are products of two primes.
     * These are semi-prime numbers which should not be identified as prime.
     */
    @Test
    public void testSemiPrimes() {
        System.out.println("Testing semi-primes (products of two primes):");
        assertFalse("6 should not be prime (2 × 3)", 
                    PrimeNumberMethod.isPrime(6));
        System.out.println("  ✓ isPrime(6) = false (2 × 3)");
        assertFalse("15 should not be prime (3 × 5)", 
                    PrimeNumberMethod.isPrime(15));
        System.out.println("  ✓ isPrime(15) = false (3 × 5)");
        assertFalse("21 should not be prime (3 × 7)", 
                    PrimeNumberMethod.isPrime(21));
        System.out.println("  ✓ isPrime(21) = false (3 × 7)");
        assertFalse("35 should not be prime (5 × 7)", 
                    PrimeNumberMethod.isPrime(35));
        System.out.println("  ✓ isPrime(35) = false (5 × 7)");
        assertFalse("77 should not be prime (7 × 11)", 
                    PrimeNumberMethod.isPrime(77));
        System.out.println("  ✓ isPrime(77) = false (7 × 11)");
    }
}

/**
 * PrimeNumberMethod class containing the isPrime method.
 * This class provides a static method to determine if a given 
 * number is prime. Based on Listing 6.7 from the textbook.
 * 
 * A prime number is a natural number greater than 1 that has
 * no positive divisors other than 1 and itself.
 * 
 * @author Your Name
 * @version 1.0
 * @since 2025-12-08
 */
class PrimeNumberMethod {
    
    /**
     * Default constructor for PrimeNumberMethod class.
     */
    public PrimeNumberMethod() {
        // Default constructor
    }
    
    /**
     * Checks if a given number is prime.
     * A prime number is a natural number greater than 1 that has
     * no positive divisors other than 1 and itself.
     * 
     * Algorithm:
     * 1. If number is less than 2, return false (not prime)
     * 2. Check for divisors from 2 to number/2
     * 3. If any divisor divides evenly, return false (not prime)
     * 4. If no divisors found, return true (is prime)
     * 
     * @param number the number to check for primality
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int number) {
        // Numbers less than 2 are not prime by definition
        if (number < 2) {
            return false;
        }
        
        // Check for divisors from 2 to number/2
        // If number has a divisor greater than number/2,
        // it must also have a corresponding divisor less than number/2
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                // Found a divisor, so number is not prime
                return false;
            }
        }
        
        // No divisors found, number is prime
        return true;
    }
}