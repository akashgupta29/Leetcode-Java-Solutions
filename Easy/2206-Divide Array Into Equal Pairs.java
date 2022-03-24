class Solution {
    // Leetcode Runtime -- 14ms
    // Time - O(N), Space - O(N)
    public boolean divideArray1(int[] nums) {
        int N = nums.length;
        if (N % 2 != 0) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                set.remove(num);
            }
        }

        return set.size() == 0;
    }

    // Leetcode Runtime -- 4ms
    // Time - O(NlogN), Space - O(1)
    public boolean divideArray(int[] nums) {
        int N = nums.length;
        if (N % 2 != 0) {
            return false;
        }

        Arrays.sort(nums);
        for (int i = 0; i < N - 1; i = i + 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
