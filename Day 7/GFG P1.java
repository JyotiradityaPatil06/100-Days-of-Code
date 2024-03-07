// GFG: Longest repeating and non-overlapping substring

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    static String longestSubstring(String s, int n) {
        int[][] dp = new int[n + 1][n + 1];

        int maxLen = 0, index = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    if (i + dp[i - 1][j - 1] < j) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        if (dp[i][j] > maxLen) {
                            maxLen = dp[i][j];
                            index = i - maxLen;
                        }
                    }
                }
            }
        }

        if (maxLen == 0)
            return "-1";
        else
            return s.substring(index, index + maxLen);
    }
}