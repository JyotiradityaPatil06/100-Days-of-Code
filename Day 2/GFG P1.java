// First element to occur k times (GFG)

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(inputLine[i]);

            Solution obj = new Solution();
            System.out.println(obj.firstElementKTime(n, k, arr));
        }
    }
}

// } Driver Code Ends

class Solution {
    public int firstElementKTime(int n, int k, int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            if (map.get(a[i]) == k) {
                return a[i];
            }
        }
        return -1;
    }
}

// explanation:
// // The code is trying to find the first element in an array that appears
// exactly k times.
// It does this by using a HashMap, which is a data structure that stores
// key-value pairs.
// In this case, the keys are the elements in the array and the values are their
// corresponding frequencies.
// First, we initialize an empty HashMap called "map".
// Then, we loop through each element in the array "a" and add it as a key to
// our map if it doesn't already exist.
// If it does exist, we increment its value (frequency) by 1.
// Next, we check if the current element's frequency equals k. If it does, then
// we have found our desired element and return it.
// Otherwise, we continue looping through the rest of the elements until either
// all elements have been checked or our desired element has been found.
// If no such element exists (i.e., all elements appear less than k times), then
// -1 is returned at the end of execution.
// This solution utilizes two important programming concepts: data structures
// and control flow.
// - Data structures allow us to store and organize data efficiently for easier
// access later on.
// In this case, using a HashMap allows us to quickly retrieve information about
// specific elements in our array without having to iterate through every single
// one.
// - Control flow refers to how a program executes different blocks of code
// based on certain conditions or criteria.
// In this case, our program checks whether an element's frequency matches k
// before deciding what action to take next (returning that
// The code attempts to find the first element in an array that appears exactly
// k times and return it, or return -1 if no such element exists.