// Leetcode 791. Custom Sort String

class Solution {
    public String customSortString(String order, String s) {
        StringBuilder ret = new StringBuilder();
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count frequency of characters in s
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Append characters in order to ret
        for (char c : order.toCharArray()) {
            if (freqMap.containsKey(c)) {
                int freq = freqMap.get(c);
                while (freq > 0) {
                    ret.append(c);
                    freq--;
                }
                freqMap.remove(c);
            }
        }

        // Append remaining characters in s to ret
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();
            while (freq > 0) {
                ret.append(c);
                freq--;
            }
        }

        return ret.toString();
    }
}