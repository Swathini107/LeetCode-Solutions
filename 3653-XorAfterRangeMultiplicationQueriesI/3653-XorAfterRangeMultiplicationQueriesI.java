// Last updated: 9/29/2026, 11:05:20 AM
class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = 1_000_000_007;

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            for (int i = l; i <= r; i += k) {
                nums[i] = (int)((nums[i] * 1L * v) % MOD);
            }
        }

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}