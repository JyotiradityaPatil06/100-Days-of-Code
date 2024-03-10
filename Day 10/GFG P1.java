// GFG: Remove all duplicates from a given string

//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    String removeDuplicates(String str) {
        int[] v1 = new int[26];
        int[] v2 = new int[26];
        StringBuilder s = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                if (v1[ch - 'A'] == 0) {
                    s.append(ch);
                }
                v1[ch - 'A']++;
            }
            if (ch >= 'a' && ch <= 'z') {
                if (v2[ch - 'a'] == 0) {
                    s.append(ch);
                }
                v2[ch - 'a']++;
            }
        }
        return s.toString();
    }
}
