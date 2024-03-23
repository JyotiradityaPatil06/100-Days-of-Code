// GFG: Longest Prefix Suffix

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    int lps(String s) {

        int pie[] = new int[s.length()];

        int pre = 0, suf = 1;

        while (suf < s.length()) {
            if (s.charAt(pre) == s.charAt(suf)) {
                pie[suf] = pre + 1;
                pre++;
                suf++;
            } else {
                if (pre == 0) {
                    pie[suf] = 0;
                    suf++;
                } else {
                    pre = pie[pre - 1];
                }
            }
        }

        return pie[s.length() - 1];
    }
}