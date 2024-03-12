// GFG: The Painter's Partition Problem-II

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, n, k));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    static long countPainters(int[] arr, long time, int m) {
        long boardPainters = 0;
        long painters = 1;
        for (int i = 0; i < arr.length; i++) {
            if (boardPainters + arr[i] <= time) {
                boardPainters += arr[i]; // allocate board to current painter
            } else {
                painters++;
                boardPainters = arr[i]; // allocate board to next painter
            }
        }
        return painters;
    }

    static long minTime(int[] arr, int n, int k) {
        long low = arr[0];
        long high = 0;
        for (int i = 0; i < n; i++) { // find maximum and summation:
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        // apply binary search
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long painters = countPainters(arr, mid, k);
            if ((int) painters > k) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return low;
    }
}
