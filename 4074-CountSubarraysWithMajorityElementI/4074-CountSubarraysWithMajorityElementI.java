// Last updated: 7/7/2026, 10:57:53 PM
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == target) {
                    sum += 1;
                } else {
                    sum -= 1;
                }

                if (sum > 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}