// Leetcode 442. Find All Duplicates in an Array

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctInd = nums[i] - 1;
            if (nums[i] != nums[correctInd]) {
                swap(nums, i, correctInd);
            } else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                ans.add(nums[index]);
            }
        }
        return ans;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}