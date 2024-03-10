// Leetcode 349. Intersection of Two Arrays

class Solution {
    public int[] intersection(int[] a1, int[] a2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int num : a1) {
            set.add(num);
        }

        for (int num : a2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }

        int[] res = new int[intersect.size()];
        int index = 0;
        for (int num : intersect) {
            res[index++] = num;
        }

        return res;
    }
}