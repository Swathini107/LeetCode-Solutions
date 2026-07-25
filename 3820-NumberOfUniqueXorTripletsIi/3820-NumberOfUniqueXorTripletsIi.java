// Last updated: 7/25/2026, 9:04:16 AM
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[] pairXor = new boolean[MAX];
        boolean[] ans = new boolean[MAX];

        int n = nums.length;

        // All XOR values of pairs (j, k) where j <= k
        for (int j = 0; j < n; j++) {
            for (int k = j; k < n; k++) {
                pairXor[nums[j] ^ nums[k]] = true;
            }
        }

        // Combine every element with every possible pair XOR
        for (int x : nums) {
            for (int v = 0; v < MAX; v++) {
                if (pairXor[v]) {
                    ans[x ^ v] = true;
                }
            }
        }

        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }

        return count;
    }
}