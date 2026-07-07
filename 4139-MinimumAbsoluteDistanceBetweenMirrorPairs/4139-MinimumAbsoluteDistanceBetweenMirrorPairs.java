// Last updated: 7/7/2026, 10:57:43 PM
import java.util.*;

class Solution {

    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> prev = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            // Check if there exists j such that reverse(nums[j]) = x
            if (prev.containsKey(x)) {
                ans = Math.min(ans, i - prev.get(x));
            }

            // Store current index as candidate for future matches
            int rev = reverse(x);
            prev.put(rev, i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}