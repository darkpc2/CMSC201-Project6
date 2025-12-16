/*
 * Class: CMSC201 20809
 * Instructor: Grigoriy Grinberg
 * Description: JUnit test class to test the methods length, charAt, 
 *              substring, and indexOf in the java.lang.String class.
 *              This program validates the functionality of core String
 *              methods using comprehensive test cases including edge cases,
 *              normal operations, and exception handling scenarios.
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
 * JUnit test class for testing java.lang.String methods.
 * This class contains comprehensive test methods for length(), charAt(), 
 * substring(), and indexOf() methods of the String class.
 * 
 * @author Your Name
 * @version 1.0
 * @since 2025-12-08
 */
public class StringTest {

    /**
     * Default constructor for StringTest class.
     * This constructor is used by JUnit to create test instances.
     */
    public StringTest() {
        // Default constructor
    }

    /**
     * Executes once before all tests.
     * Prints header information to console.
     */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("=====================================");
        System.out.println("Starting StringTest JUnit Tests");
        System.out.println("Testing String methods: length, charAt, substring, indexOf");
        System.out.println("=====================================\n");
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
        System.out.println("=====================================");
        System.out.println("All StringTest tests completed!");
        System.out.println("=====================================");
    }

    /**
     * Tests the length() method of String class.
     * Verifies that the length method returns correct string lengths
     * for various test cases including empty strings, single characters,
     * and strings with spaces and special characters.
     */
    @Test
    public void testLength() {
        System.out.println("Testing length() method:");
        
        // Test case 1: Empty string
        assertEquals("Empty string should have length 0", 0, "".length());
        System.out.println("  ✓ Empty string length = 0");
        
        // Test case 2: Single character
        assertEquals("Single character should have length 1", 1, "a".length());
        System.out.println("  ✓ Single character 'a' length = 1");
        
        // Test case 3: Normal string
        assertEquals("'Hello' should have length 5", 5, "Hello".length());
        System.out.println("  ✓ 'Hello' length = 5");
        
        // Test case 4: String with spaces
        assertEquals("'Hello World' should have length 11", 11, "Hello World".length());
        System.out.println("  ✓ 'Hello World' length = 11");
        
        // Test case 5: String with special characters
        assertEquals("'Hello, World!' should have length 13", 13, "Hello, World!".length());
        System.out.println("  ✓ 'Hello, World!' length = 13");
        
        // Test case 6: String with numbers
        assertEquals("'12345' should have length 5", 5, "12345".length());
        System.out.println("  ✓ '12345' length = 5");
    }

    /**
     * Tests the charAt() method of String class.
     * Verifies that charAt returns the correct character at 
     * specified index positions including first, middle, and last positions.
     */
    @Test
    public void testCharAt() {
        System.out.println("Testing charAt() method:");
        String test = "Hello";
        
        // Test case 1: First character
        assertEquals("First character should be 'H'", 'H', test.charAt(0));
        System.out.println("  ✓ 'Hello'.charAt(0) = 'H'");
        
        // Test case 2: Middle character
        assertEquals("Character at index 2 should be 'l'", 'l', test.charAt(2));
        System.out.println("  ✓ 'Hello'.charAt(2) = 'l'");
        
        // Test case 3: Last character
        assertEquals("Last character should be 'o'", 'o', test.charAt(4));
        System.out.println("  ✓ 'Hello'.charAt(4) = 'o'");
        
        // Test case 4: Different string
        String test2 = "Java Programming";
        assertEquals("First character should be 'J'", 'J', test2.charAt(0));
        System.out.println("  ✓ 'Java Programming'.charAt(0) = 'J'");
        assertEquals("Character at index 4 should be space", ' ', test2.charAt(4));
        System.out.println("  ✓ 'Java Programming'.charAt(4) = ' '");
        assertEquals("Last character should be 'g'", 'g', test2.charAt(15));
        System.out.println("  ✓ 'Java Programming'.charAt(15) = 'g'");
        
        // Test case 5: String with numbers
        String test3 = "Test123";
        assertEquals("Character at index 4 should be '1'", '1', test3.charAt(4));
        System.out.println("  ✓ 'Test123'.charAt(4) = '1'");
    }

    /**
     * Tests the charAt() method with invalid index.
     * Verifies that StringIndexOutOfBoundsException is thrown
     * when accessing an index outside the valid range.
     */
    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testCharAtException() {
        System.out.println("Testing charAt() exception handling:");
        System.out.println("  ✓ Attempting charAt(10) on 'Hello' - should throw exception");
        String test = "Hello";
        // This should throw StringIndexOutOfBoundsException
        test.charAt(10);
    }

    /**
     * Tests the substring() method with one parameter.
     * Verifies that substring correctly extracts characters
     * from the beginning index to the end of the string.
     */
    @Test
    public void testSubstringOneParameter() {
        System.out.println("Testing substring(int) method:");
        String test = "Hello World";
        
        // Test case 1: Substring from beginning
        assertEquals("Substring from 0 should return full string", 
                     "Hello World", test.substring(0));
        System.out.println("  ✓ 'Hello World'.substring(0) = 'Hello World'");
        
        // Test case 2: Substring from middle
        assertEquals("Substring from 6 should return 'World'", 
                     "World", test.substring(6));
        System.out.println("  ✓ 'Hello World'.substring(6) = 'World'");
        
        // Test case 3: Substring near end
        assertEquals("Substring from 10 should return 'd'", 
                     "d", test.substring(10));
        System.out.println("  ✓ 'Hello World'.substring(10) = 'd'");
        
        // Test case 4: Substring at end
        assertEquals("Substring from 11 should return empty string", 
                     "", test.substring(11));
        System.out.println("  ✓ 'Hello World'.substring(11) = ''");
        
        // Test case 5: Different string
        String test2 = "Programming";
        assertEquals("Substring from 3 should return 'gramming'", 
                     "gramming", test2.substring(3));
        System.out.println("  ✓ 'Programming'.substring(3) = 'gramming'");
    }

    /**
     * Tests the substring() method with two parameters.
     * Verifies that substring correctly extracts characters
     * between the specified beginning and ending indices.
     */
    @Test
    public void testSubstringTwoParameters() {
        System.out.println("Testing substring(int, int) method:");
        String test = "Hello World";
        
        // Test case 1: Full string
        assertEquals("Substring(0, 11) should return full string", 
                     "Hello World", test.substring(0, 11));
        System.out.println("  ✓ 'Hello World'.substring(0, 11) = 'Hello World'");
        
        // Test case 2: First word
        assertEquals("Substring(0, 5) should return 'Hello'", 
                     "Hello", test.substring(0, 5));
        System.out.println("  ✓ 'Hello World'.substring(0, 5) = 'Hello'");
        
        // Test case 3: Second word
        assertEquals("Substring(6, 11) should return 'World'", 
                     "World", test.substring(6, 11));
        System.out.println("  ✓ 'Hello World'.substring(6, 11) = 'World'");
        
        // Test case 4: Single character
        assertEquals("Substring(0, 1) should return 'H'", 
                     "H", test.substring(0, 1));
        System.out.println("  ✓ 'Hello World'.substring(0, 1) = 'H'");
        
        // Test case 5: Empty substring
        assertEquals("Substring(5, 5) should return empty string", 
                     "", test.substring(5, 5));
        System.out.println("  ✓ 'Hello World'.substring(5, 5) = ''");
        
        // Test case 6: Middle portion
        assertEquals("Substring(2, 9) should return 'llo Wor'", 
                     "llo Wor", test.substring(2, 9));
        System.out.println("  ✓ 'Hello World'.substring(2, 9) = 'llo Wor'");
    }

    /**
     * Tests the indexOf() method with character parameter.
     * Verifies that indexOf correctly finds the first occurrence
     * of a specified character and returns -1 when not found.
     */
    @Test
    public void testIndexOfChar() {
        System.out.println("Testing indexOf(char) method:");
        String test = "Hello World";
        
        // Test case 1: First character
        assertEquals("indexOf('H') should return 0", 0, test.indexOf('H'));
        System.out.println("  ✓ 'Hello World'.indexOf('H') = 0");
        
        // Test case 2: Character in middle
        assertEquals("indexOf('W') should return 6", 6, test.indexOf('W'));
        System.out.println("  ✓ 'Hello World'.indexOf('W') = 6");
        
        // Test case 3: Repeated character (should return first occurrence)
        assertEquals("indexOf('l') should return 2", 2, test.indexOf('l'));
        System.out.println("  ✓ 'Hello World'.indexOf('l') = 2 (first occurrence)");
        
        // Test case 4: Character not in string
        assertEquals("indexOf('x') should return -1", -1, test.indexOf('x'));
        System.out.println("  ✓ 'Hello World'.indexOf('x') = -1 (not found)");
        
        // Test case 5: Space character
        assertEquals("indexOf(' ') should return 5", 5, test.indexOf(' '));
        System.out.println("  ✓ 'Hello World'.indexOf(' ') = 5");
        
        // Test case 6: Last character
        assertEquals("indexOf('d') should return 10", 10, test.indexOf('d'));
        System.out.println("  ✓ 'Hello World'.indexOf('d') = 10");
        
        // Test case 7: Another repeated character
        assertEquals("indexOf('o') should return 4", 4, test.indexOf('o'));
        System.out.println("  ✓ 'Hello World'.indexOf('o') = 4 (first occurrence)");
    }

    /**
     * Tests the indexOf() method with String parameter.
     * Verifies that indexOf correctly finds the first occurrence
     * of a specified substring and returns -1 when not found.
     */
    @Test
    public void testIndexOfString() {
        System.out.println("Testing indexOf(String) method:");
        String test = "Hello World";
        
        // Test case 1: Finding word at beginning
        assertEquals("indexOf('Hello') should return 0", 
                     0, test.indexOf("Hello"));
        System.out.println("  ✓ 'Hello World'.indexOf('Hello') = 0");
        
        // Test case 2: Finding word at end
        assertEquals("indexOf('World') should return 6", 
                     6, test.indexOf("World"));
        System.out.println("  ✓ 'Hello World'.indexOf('World') = 6");
        
        // Test case 3: Finding substring
        assertEquals("indexOf('llo') should return 2", 
                     2, test.indexOf("llo"));
        System.out.println("  ✓ 'Hello World'.indexOf('llo') = 2");
        
        // Test case 4: Substring not in string
        assertEquals("indexOf('xyz') should return -1", 
                     -1, test.indexOf("xyz"));
        System.out.println("  ✓ 'Hello World'.indexOf('xyz') = -1 (not found)");
        
        // Test case 5: Single character as string
        assertEquals("indexOf('o') should return 4", 
                     4, test.indexOf("o"));
        System.out.println("  ✓ 'Hello World'.indexOf('o') = 4");
        
        // Test case 6: Space as substring
        assertEquals("indexOf(' ') should return 5", 
                     5, test.indexOf(" "));
        System.out.println("  ✓ 'Hello World'.indexOf(' ') = 5");
        
        // Test case 7: Substring spanning words
        assertEquals("indexOf('o W') should return 4", 
                     4, test.indexOf("o W"));
        System.out.println("  ✓ 'Hello World'.indexOf('o W') = 4");
    }

    /**
     * Tests the indexOf() method with starting position parameter.
     * Verifies that indexOf correctly finds occurrences
     * starting from a specified index (fromIndex parameter).
     */
    @Test
    public void testIndexOfWithFromIndex() {
        System.out.println("Testing indexOf(char, fromIndex) method:");
        String test = "Hello World";
        
        // Test case 1: Finding character from specific index
        assertEquals("indexOf('o', 5) should return 7", 
                     7, test.indexOf('o', 5));
        System.out.println("  ✓ 'Hello World'.indexOf('o', 5) = 7");
        
        // Test case 2: Finding character from its own position
        assertEquals("indexOf('l', 3) should return 3", 
                     3, test.indexOf('l', 3));
        System.out.println("  ✓ 'Hello World'.indexOf('l', 3) = 3");
        
        // Test case 3: Character doesn't exist after fromIndex
        assertEquals("indexOf('H', 5) should return -1", 
                     -1, test.indexOf('H', 5));
        System.out.println("  ✓ 'Hello World'.indexOf('H', 5) = -1 (not found after index 5)");
        
        // Test case 4: String parameter with fromIndex
        assertEquals("indexOf('o', 5) should return 7", 
                     7, test.indexOf("o", 5));
        System.out.println("  ✓ 'Hello World'.indexOf('o', 5) = 7");
        
        // Test case 5: Finding from beginning
        assertEquals("indexOf('l', 0) should return 2", 
                     2, test.indexOf('l', 0));
        System.out.println("  ✓ 'Hello World'.indexOf('l', 0) = 2");
        
        // Test case 6: Finding second occurrence of 'l'
        assertEquals("indexOf('l', 3) should return 3", 
                     3, test.indexOf('l', 3));
        System.out.println("  ✓ 'Hello World'.indexOf('l', 3) = 3");
    }
}