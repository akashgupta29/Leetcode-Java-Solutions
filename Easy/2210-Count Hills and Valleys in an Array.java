class Solution {
    public int countHillValley(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }

        int N = nums.length;
        int prev = 0, curr = 1;
        int count = 0;
        while (curr < N - 1) {
            int left = nums[prev];
            int right = nums[curr + 1];
            // If the current element is equal to the next element => we just move the curr pointer by one
            // Reason: since they are at same level, they are considered part of the same hill or valley
            if (nums[curr] != right) {
                if ((left < nums[curr] && right < nums[curr]) ||
                    (left > nums[curr] && right > nums[curr])) {
                    count++;
                }
                prev = curr;
            }

            curr++;
        }

        return count;
    }
}
