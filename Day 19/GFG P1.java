// GFG: Possible Paths in a Tree

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            int edges[][] = new int[n - 1][3];
            for (int i = 0; i < (n - 1); i++) {
                String input_line[] = read.readLine().trim().split("\\s+");
                for (int j = 0; j < 3; j++) {
                    edges[i][j] = Integer.parseInt(input_line[j]);
                }
            }

            int q = Integer.parseInt(read.readLine());

            String input_line[] = read.readLine().trim().split("\\s+");
            int queries[] = new int[q];
            for (int i = 0; i < q; i++)
                queries[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.maximumWeight(n, edges, q, queries);
            for (Integer val : ans)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int ans;

    static int root(int i, int[] parent) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    static int Union(int a, int b, int[] parent, int[] sz) {
        int ra = root(a, parent);
        int rb = root(b, parent);
        if (ra == rb)
            return sz[ra] * sz[ra];
        if (sz[ra] < sz[rb]) {
            int temp = ra;
            ra = rb;
            rb = temp;
            temp = a;
            a = b;
            b = temp;
        }

        ans += sz[ra] * sz[rb];
        parent[rb] = ra;
        sz[ra] += sz[rb];
        return ans;
    }

    static ArrayList<Integer> maximumWeight(int n, int edges[][], int q, int queries[]) {
        // code here
        ans = 0;
        int[] parent = new int[n + 1];
        int[] sz = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int i = 0; i < n - 1; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int c = edges[i][2];
            mp.put(c, Union(a, b, parent, sz));
        }
        for (int i = 0; i < q; i++) {
            Integer val = mp.floorKey(queries[i]);
            if (val == null)
                res.add(0);
            else
                res.add(mp.get(val));
        }
        return res;
    }
}