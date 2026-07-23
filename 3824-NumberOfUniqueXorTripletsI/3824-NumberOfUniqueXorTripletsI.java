// Last updated: 7/23/2026, 2:14:15 PM
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n < 3) {
            return n;
        }

        int ans = 1;
        while (ans <= n) {
            ans <<= 1;
        }

        return ans;
    }
}