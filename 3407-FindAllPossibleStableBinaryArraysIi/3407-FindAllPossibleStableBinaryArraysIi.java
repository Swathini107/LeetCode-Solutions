// Last updated: 7/7/2026, 10:58:54 PM
class Solution {

    static final int MOD = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {

        long[][] dp0 = new long[zero + 1][one + 1];
        long[][] dp1 = new long[zero + 1][one + 1];

        for (int i = 1; i <= Math.min(limit, zero); i++) {
            dp0[i][0] = 1;
        }

        for (int j = 1; j <= Math.min(limit, one); j++) {
            dp1[0][j] = 1;
        }

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {

                dp0[i][j] = dp0[i - 1][j] + dp1[i - 1][j];

                if (i - limit - 1 >= 0) {
                    dp0[i][j] = (dp0[i][j] - dp1[i - limit - 1][j] + MOD) % MOD;
                } else {
                    dp0[i][j] %= MOD;
                }

                dp1[i][j] = dp0[i][j - 1] + dp1[i][j - 1];

                if (j - limit - 1 >= 0) {
                    dp1[i][j] = (dp1[i][j] - dp0[i][j - limit - 1] + MOD) % MOD;
                } else {
                    dp1[i][j] %= MOD;
                }
            }
        }

        return (int)((dp0[zero][one] + dp1[zero][one]) % MOD);
    }
}