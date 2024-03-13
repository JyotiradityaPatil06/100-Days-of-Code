// GFG: Print matrix in diagonal pattern

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for (int k = 0; k < S.length; k++) {
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if (j == n) {
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for (int it = 0; it < ans.length; it++) {
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int[] ans = new int[n * n];
        int k = 0;

        boolean up = true;
        int r = 0, c = 0;
        while (r < n && c < n) {
            if (up) {
                while (r > 0 && c < n - 1) {
                    ans[k++] = mat[r][c];
                    r--;
                    c++;
                }
                ans[k++] = mat[r][c];
                if (c == n - 1)
                    r++;
                else
                    c++;
            } else {
                while (c > 0 && r < n - 1) {
                    ans[k++] = mat[r][c];
                    r++;
                    c--;
                }
                ans[k++] = mat[r][c];
                if (r == n - 1)
                    c++;
                else
                    r++;
            }
            up = !up;
        }

        return ans;
    }
}