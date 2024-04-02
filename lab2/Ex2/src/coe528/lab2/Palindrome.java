package coe528.lab2;
/**
 *
 * @author Owais 501181250
 */

public class Palindrome {

//Requires: The function requires string a that is non-null
//Modifies: None
//Effects: if the string is a palindrome, it will return true. Otherwise, it will return false, including null and empty strings. 

public static boolean isPalindrome(String a) {
    if (a == null || a.isEmpty()) // If the string is null or empty, it's not a palindrome
        return false;
    
    int left = 0;
    int right = a.length() - 1;
    
    while (left < right) { // Iterate from both ends towards the middle
        if (a.charAt(left) != a.charAt(right)) // If characters at symmetric positions don't match, it's not a palindrome
            return false;
        left++;
        right--;
    }
    
    return true; // If the loop completes without finding a mismatch, it's a palindrome
}

    
    
    public static void main(String[] args) {
        if(args.length == 1) {
               if (args[0].equals("1"))
                    System.out.println(isPalindrome(null));
                else if (args[0].equals("2"))
                    System.out.println(isPalindrome(""));
                else if (args[0].equals("3"))
                    System.out.println(isPalindrome("deed"));
                else if (args[0].equals("4"))
                    System.out.println(isPalindrome("abcd"));
                }
        }
}
