// GFG: Permutations of a given string

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

        }
        out.close();
    }
}

// } Driver Code Ends

class Solution {
    public List<String> find_permutation(String S) {
        char[] chars = S.toCharArray();

        Arrays.sort(chars); // Sort the input string

        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[S.length()];

        generatePermutations(chars, used, new StringBuilder(), result);
        Collections.sort(result); // Sort the result lexicographically

        return result;
    }

    private static void generatePermutations(char[] chars, boolean[] used, StringBuilder current, List<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            current.append(chars[i]);
            generatePermutations(chars, used, current, result);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}