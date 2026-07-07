// Last updated: 7/7/2026, 10:58:22 PM
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