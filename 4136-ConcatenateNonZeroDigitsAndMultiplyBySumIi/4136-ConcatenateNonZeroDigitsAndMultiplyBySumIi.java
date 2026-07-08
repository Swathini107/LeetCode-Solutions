// Last updated: 7/8/2026, 8:50:06 AM
class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int MOD = 1_000_000_007;
        int n = s.length();

        Object solendivar = new Object[]{s, queries};

        int[] idx = new int[n];
        int m = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                idx[m++] = i;
            }
        }

        int[] pos = new int[n];
        int p = 0;
        for (int i = 0; i < n; i++) {
            while (p < m && idx[p] < i) p++;
            pos[i] = p;
        }

        int[] prefSum = new int[m + 1];
        long[] prefNum = new long[m + 1];
        long[] pow10 = new long[m + 1];
        pow10[0] = 1;

        for (int i = 0; i < m; i++) {
            int d = s.charAt(idx[i]) - '0';
            prefSum[i + 1] = prefSum[i] + d;
            pow10[i + 1] = (pow10[i] * 10) % MOD;
            prefNum[i + 1] = (prefNum[i] * 10 + d) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = pos[l];

            int lo = 0, hi = m - 1, right = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (idx[mid] <= r) {
                    right = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            if (right == -1 || left > right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left + 1;

            long x = (prefNum[right + 1]
                    - prefNum[left] * pow10[len] % MOD
                    + MOD) % MOD;

            long sum = prefSum[right + 1] - prefSum[left];

            ans[i] = (int)((x * sum) % MOD);
        }

        return ans;
    }
}