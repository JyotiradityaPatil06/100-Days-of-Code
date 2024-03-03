// GFG: Find triplets with zero sum

//{ Driver Code Starts
import java.util.*;

class Triplets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution g = new Solution();
            if (g.findTriplets(a, n))
                System.out.println("1");
            else
                System.out.println("0");

        }
    }
}
// } Driver Code Ends

/* Complete the function below */

class Solution {
    // arr[]: input array
    // n: size of the array
    // Function to find triplets with zero sum.
    public boolean findTriplets(int arr[], int n) {
        boolean triplet = false;

        for (int i = 0; i < n - 1; i++) {
            Map<Integer, Boolean> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int sum = 0 - (arr[i] + arr[j]);

                if (map.containsKey(sum)) {
                    return true; // Found triplet, return true
                } else {
                    map.put(arr[j], true);
                }
            }
        }

        // No triplet found, print 0
        return false;
    }
}

// The code is a solution to the problem of finding triplets with zero sum in an
// array.
// The function takes two parameters, arr[] and n, where arr[] is the input
// array and n is its size.
// The first line declares a boolean variable named triplet and initializes it
// to false.
// This variable will be used to store whether or not a triplet with zero sum
// has been found in the array.
// The for loop iterates through each element of the array except for the last
// one (since we are looking for triplets).
// Inside this loop, another for loop is used to iterate through all elements
// after the current element being considered by the outer loop.
// Inside this inner loop, we calculate the sum of three numbers - arr[i],
// arr[j] (current element being considered by outer loop), and 0 (since we are
// looking for triplets with zero sum).
// If such a triplet exists, then it means that there are two numbers whose sum
// equals -(arr[i]+arr[j]).
// Therefore, if we can find any number in our map that equals -(arr[i]+arr[j]),
// then we have found our third number which completes our triplet.
// In order to check if such a number exists in our map or not, we use
// containsKey() method on our map object passing it as argument
// -(arr[i]+arr[j]) which returns true if such key exists else returns false.
// If containsKey() method returns true then it means that there exist three
// numbers whose sum equals 0 i.e., they form a triplet with zero sum.
// Hence at this point inside innermost if block return statement executes
// returning true indicating that such triplets exist.
// However, if no matching key was found inside map using containsKey(), then it
// means that no pair existed whose sums equaled -(arr[i]+arr[j]).
// Therefore add current value of jth index into map as key alongwith some
// arbitrary value say 'true' so
// The code attempts to find triplets with zero sum in an input array and return
// true if such a triplet exists, otherwise return false.