// GFG: Triplet Sum in Array

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int X = Integer.parseInt(inputLine[1]);
            int A[] = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.find3Numbers(A, n, X);
            System.out.println(ans ? 1 : 0);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to find if there exists a triplet in the
    // array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int X) {

        int left;
        int right;
        Arrays.sort(A);

        for (int i = 0; i < n - 2; i++) {

            left = i + 1;
            right = n - 1;

            while (left < right) {
                if (A[i] + A[left] + A[right] == X) {
                    return true;
                } else if (A[i] + A[left] + A[right] < X) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return false;
    }
}

// The code is a Java program that searches for a triplet in an array of
// integers whose sum equals to the given value.
// The code takes three arguments: arr, n and sum.
// Arr is the input array, n is the size of the array and sum is the target
// value.
// The first step in this code is to sort the elements in ascending order using
// Arrays.sort() method.
// This will make it easier to find triplets as we can use two pointer approach
// where one pointer starts from left (l) and another from right (r).
// Next, we have a for loop which iterates through each element of the array
// except last two elements because there are no more possible combinations
// after that point.
// Inside this loop, we initialize l = i+1 and r = n-1.
// These pointers represent starting index of second element and last element
// respectively.
// We then enter into a while loop with condition l < r which means that both
// pointers should not cross each other or else there won't be any combination
// left to check.
// Inside this while loop, we check if current triplet's sum equals our target
// value or not by adding all three values at indices i,l,r respectively.
// If they match then we print out those values as our desired triplet has been
// found.
// If current triplet's sum is less than target value then it means that our
// middle number was too small so we increment l by 1 so that next iteration
// checks with bigger number on its left side.
// Similarly if current triplet's sum exceeds target value then it means our
// third number was too big so decrement r by 1 so next iteration checks with
// smaller number on its right side.
// If no such combination exists till end of outer for loop execution then
// function returns false indicating no such triplets were found.
// The code attempts to find a triplet in a given array of integers that adds up
// to a given sum.
