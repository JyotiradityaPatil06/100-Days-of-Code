// GFG: Find the N-th character

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int R = sc.nextInt();
            int N = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.nthCharacter(S, R, N));
        }

    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public char nthCharacter(String str, int r, int n) {
        double final_multiplier = Math.pow(2, r);
        char ch = '*';

        while (r > 0) {

            int index = (int) Math.floor(n / final_multiplier);
            ch = str.charAt(index);

            str = (ch == '0') ? "01" : "10";

            n = n % (int) final_multiplier;

            --r;
            final_multiplier /= 2;
        }
        return str.charAt((int) Math.floor(n / final_multiplier));
    }
}