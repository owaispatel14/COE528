package coe528.lab3;
import java.util.Arrays;
/**
 *
 * @author Owais 501181250
 */
public class AnagramChecker {
    
//Requires: two inputs that are not null and are strings, s1 and s2. these are the words that will be checked for anagrams.
//Modifies:
//Effects: It will return true if the input strings are anagrams, and false otherwise. If the lengths of the inputs are different, it will also return false.
    
    public static boolean areAnagrams(String s1, String s2) {
        // Remove white spaces and convert both strings to lowercase
        String s1Trimmed = s1.replaceAll("\\s+", "").toLowerCase();
        String s2Trimmed = s2.replaceAll("\\s+", "").toLowerCase();

        // Check if the lengths of the strings are the same after trimming and lowercasing
            if (s1Trimmed.length() != s2Trimmed.length()) 
                 return false; // Different lengths cannot be anagrams

            // Sort the characters of both strings
            char[] s1Sorted = s1Trimmed.toCharArray();
            char[] s2Sorted = s2Trimmed.toCharArray();
            Arrays.sort(s1Sorted);
            Arrays.sort(s2Sorted);

            // Check if the sorted strings are equal
            return Arrays.equals(s1Sorted, s2Sorted);
}


    
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide two strings as command line arguments.");
            return;
        }
        System.out.println(areAnagrams(args[0], args[1]));
    }   
    }

    
