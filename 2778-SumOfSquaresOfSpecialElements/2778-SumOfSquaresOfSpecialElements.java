// Last updated: 10/19/2026, 6:51:09 PM
class Solution {
    public int sumOfSquares(int[] nums) {
        int ans = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (nums.length % i == 0)
                ans += nums[i - 1] * nums[i - 1];
        }
        return ans;
    }
}