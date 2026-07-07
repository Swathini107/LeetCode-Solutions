// Last updated: 7/7/2026, 10:58:21 PM
class Solution {
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) return m;

        long[] up = new long[m];
        long[] down = new long[m];

        // Build length = 2 states
        for (int y = 0; y < m; y++) {
            up[y] = y;              // values smaller than y
            down[y] = m - 1 - y;    // values greater than y
        }

        // Build lengths 3...n
        for (int len = 3; len <= n; len++) {
            long[] newUp = new long[m];
            long[] newDown = new long[m];

            long[] preDown = new long[m + 1];
            long[] sufUp = new long[m + 1];

            for (int i = 0; i < m; i++) {
                preDown[i + 1] = (preDown[i] + down[i]) % MOD;
            }

            for (int i = m - 1; i >= 0; i--) {
                sufUp[i] = (sufUp[i + 1] + up[i]) % MOD;
            }

            for (int y = 0; y < m; y++) {
                newUp[y] = preDown[y];
                newDown[y] = sufUp[y + 1];
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}