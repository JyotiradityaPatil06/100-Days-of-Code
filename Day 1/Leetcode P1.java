// Leetcode 2864. Maximum Odd Binary Number

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int i = s.length() - 1;
        while (s.charAt(i) != '1') {
            i--;
        }
        char[] arr = s.toCharArray();
        swap(arr, i, arr.length - 1);
        int l = 0, r = i - 1;
        while (l < r && r >= 0) {
            while (l <= r && r >= 0 && arr[r] == '1') {
                swap(arr, l, r);
                l++;
            }
            r--;
        }
        return new String(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
