// Last updated: 7/7/2026, 11:01:20 PM
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        long totalSum = 0;
        long F = 0;

        // Compute totalSum and F(0)
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            F += (long) i * nums[i];
        }

        long max = F;

        // Compute F(k) using recurrence
        for (int k = 1; k < n; k++) {
            F = F + totalSum - (long) n * nums[n - k];
            max = Math.max(max, F);
        }

        return (int) max;
    }
}