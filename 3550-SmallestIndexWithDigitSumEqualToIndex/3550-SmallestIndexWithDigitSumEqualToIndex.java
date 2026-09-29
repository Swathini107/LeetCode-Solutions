// Last updated: 9/29/2026, 11:06:04 AM
class Solution {
    public int smallestIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int sum = 0;

            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }

            if (sum == i)
                return i;
        }

        return -1;
    }
}