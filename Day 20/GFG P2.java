// GFG: Reverse words in a given string

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String S) {
        String[] words = S.split("\\.");
        Collections.reverse(Arrays.asList(words));
        String reversedString = String.join(".", words);
        return reversedString;
    }
}
