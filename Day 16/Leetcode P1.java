// Leetcode 525. Contiguous Array

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] sumToIndex = new int[2 * n + 1];
        Arrays.fill(sumToIndex, -2); // Initialize all to -2, -2 means not visited
        sumToIndex[n] = -1; // To handle the case when sum becomes 0
        int sum = 0, maxLength = 0;
        for (int i = 0; i < n; i++) {
            sum += (nums[i] == 0 ? -1 : 1);
            if (sumToIndex[sum + n] != -2) {
                maxLength = Math.max(maxLength, i - sumToIndex[sum + n]);
            } else {
                sumToIndex[sum + n] = i;
            }
        }
        return maxLength;
    }
}