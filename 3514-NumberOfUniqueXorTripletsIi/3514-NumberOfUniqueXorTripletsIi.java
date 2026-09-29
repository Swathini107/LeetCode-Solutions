// Last updated: 9/29/2026, 11:06:38 AM
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