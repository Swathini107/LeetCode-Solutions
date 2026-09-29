// Last updated: 9/29/2026, 11:08:53 AM
class Solution {
    public boolean isGood(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length - 1;

        // Last two elements must be n
        if (nums[nums.length - 1] != n ||
            nums[nums.length - 2] != n) {
            return false;
        }

        // Check 1 to n-1 exactly once
        for (int i = 0; i < n - 1; i++) {

            if (nums[i] != i + 1) {
                return false;
            }
        }

        return true;
    }
}