// Last updated: 7/7/2026, 10:58:05 PM
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return (long) k * (max - min);
    }
}