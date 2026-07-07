// Last updated: 7/7/2026, 10:59:12 PM
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