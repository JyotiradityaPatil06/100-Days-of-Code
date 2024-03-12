// GFG: Generalised Fibonacci numbers

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            long a = Long.parseLong(S[0]);
            long b = Long.parseLong(S[1]);
            long c = Long.parseLong(S[2]);
            long n = Long.parseLong(S[3]);
            long m = Long.parseLong(S[4]);

            Solution ob = new Solution();
            System.out.println(ob.genFibNum(a, b, c, n, m));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    private long[][] mat;
    private long[][] res;

    private void multiply(long[][] res, long[][] mat, long m) {
        long[][] res1 = new long[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    res1[i][j] += (res[i][k] * mat[k][j]) % m;
                    res1[i][j] %= m;
                }
            }
        }
        for (int i = 0; i < 3; ++i) {
            System.arraycopy(res1[i], 0, res[i], 0, 3);
        }
    }

    private void matrixExponentiation(long n, long m) {
        while (n > 0) {
            if ((n & 1) == 1) {
                multiply(res, mat, m);
            }
            multiply(mat, mat, m);
            n /= 2;
        }
    }

    public long genFibNum(long a, long b, long c, long n, long m) {
        res = new long[3][3];
        for (int i = 0; i < 3; ++i) {
            res[i][i] = 1;
        }

        mat = new long[3][3];
        mat[0][0] = a;
        mat[0][1] = b;
        mat[0][2] = mat[1][0] = mat[2][2] = 1;
        mat[1][1] = mat[1][2] = mat[2][0] = mat[2][1] = 0;

        if (n <= 2) {
            return 1 % m;
        } else {
            matrixExponentiation(n - 2, m);
            return (res[0][0] + res[0][1] + c * res[0][2]) % m;
        }
    }
}