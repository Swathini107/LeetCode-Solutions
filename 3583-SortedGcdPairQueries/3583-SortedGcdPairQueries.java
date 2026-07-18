// Last updated: 7/18/2026, 10:12:58 AM
class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] cnt = new long[max + 1];

        // Count pairs having gcd exactly g
        for (int g = max; g >= 1; g--) {
            long c = 0;
            for (int j = g; j <= max; j += g)
                c += freq[j];

            cnt[g] = c * (c - 1) / 2;

            for (int j = g * 2; j <= max; j += g)
                cnt[g] -= cnt[j];
        }

        // Prefix of sorted gcd values
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++)
            prefix[i] = prefix[i - 1] + cnt[i];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1; // 0-indexed -> 1-indexed

            int l = 1, r = max;
            while (l < r) {
                int mid = (l + r) / 2;
                if (prefix[mid] >= k)
                    r = mid;
                else
                    l = mid + 1;
            }
            ans[i] = l;
        }

        return ans;
    }
}