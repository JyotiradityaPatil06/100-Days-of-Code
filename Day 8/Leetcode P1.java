// Leetcode 3005. Count Elements With Maximum Frequency

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;
        int sum = 0;
        for (int freq : frequencyMap.values()) {
            if (freq > maxFrequency) {
                maxFrequency = freq;
                sum = maxFrequency;
            } else if (freq == maxFrequency) {
                sum += freq;
            }
        }

        return sum;
    }
}