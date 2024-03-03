// GFG: Largest Number formed from an Array

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(n, arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    String printLargest(int n, String[] arr) {
        // Sort the array of strings using a custom comparator
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Concatenate the sorted strings to get the largest possible arrangement
        return String.join("", Arrays.copyOf(arr, n));
    }
}

// The code is trying to find the largest possible arrangement of strings from
// an array.
// It does this by first sorting the array using a custom comparator, which
// compares two strings by concatenating them in different orders and then
// comparing them lexicographically (alphabetically).
// This ensures that the larger string comes before the smaller one.
// Once the array is sorted, it uses String.join() method to concatenate all the
// strings in order, starting with the largest one.
// This results in a single string which represents the largest possible
// arrangement of strings from the given array.
// This solution makes use of two important programming concepts - sorting and
// custom comparators.
// Sorting is a common technique used to arrange elements in a specific order,
// such as ascending or descending.
// In this case, we are using a custom comparator to define our own way of
// comparing two strings instead of relying on their natural ordering.
// A comparator is an interface that allows us to compare objects based on some
// criteria.
// In this case, we are defining our own logic for comparison by concatenating
// two strings and then comparing them lexicographically.
// Overall, this solution demonstrates how we can use sorting and custom
// comparators together to solve problems involving arranging elements in a
// specific order according to our own criteria.
// The code sorts the given array of strings in a way that the resulting string
// is the largest possible arrangement of the given strings.