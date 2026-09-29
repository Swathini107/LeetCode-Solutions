// Last updated: 9/29/2026, 11:06:35 AM
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