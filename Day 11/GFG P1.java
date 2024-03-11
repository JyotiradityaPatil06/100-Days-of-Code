// GFG: Count pairs Sum in matrices

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");

            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);

            int mat1[][] = new int[n][n];

            for (int i = 0; i < n; i++) {
                input = read.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }

            int mat2[][] = new int[n][n];

            for (int i = 0; i < n; i++) {
                input = read.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1, mat2, n, x));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public boolean check(int[][] mat2, int n, int x) {
        int i = 0;
        int j = n - 1;
        while (i >= 0 && i < n && j >= 0 && j < n) {
            if (mat2[i][j] == x) {
                return true;
            } else if (mat2[i][j] < x) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public int countPairs(int[][] mat1, int[][] mat2, int n, int x) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int c = x - mat1[i][j];
                if (check(mat2, n, c)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}