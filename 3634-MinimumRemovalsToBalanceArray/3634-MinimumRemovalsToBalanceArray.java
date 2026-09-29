// Last updated: 9/29/2026, 11:05:38 AM
import java.util.Arrays;
class Solution {
    public int minRemoval(int[] nums, int k) {
                Arrays.sort(nums);
        int n = nums.length;

        int left = 0;
        int maxLen = 1;

        for (int right = 0; right < n; right++) {
            
            while ((long) nums[right] > (long) nums[left] * k) {
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return n - maxLen;

    }
}