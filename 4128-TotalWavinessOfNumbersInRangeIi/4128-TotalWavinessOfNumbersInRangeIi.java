// Last updated: 7/7/2026, 10:57:46 PM
class Solution {

    private char[] digits;
    private long[][][][] memoCnt;
    private long[][][][] memoWave;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long num) {
        if (num < 100) return 0;

        digits = String.valueOf(num).toCharArray();
        int n = digits.length;

        memoCnt = new long[n][11][11][2];
        memoWave = new long[n][11][11][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 11; k++) {
                    for (int t = 0; t < 2; t++) {
                        memoCnt[i][j][k][t] = -1;
                        memoWave[i][j][k][t] = -1;
                    }
                }
            }
        }

        return dfs(0, 10, 10, 1)[1];
    }

    private long[] dfs(int pos, int prev1, int prev2, int tight) {

        if (pos == digits.length) {
            return new long[]{1, 0};
        }

        if (memoCnt[pos][prev1][prev2][tight] != -1) {
            return new long[]{
                memoCnt[pos][prev1][prev2][tight],
                memoWave[pos][prev1][prev2][tight]
            };
        }

        long count = 0;
        long waviness = 0;

        int limit = (tight == 1) ? digits[pos] - '0' : 9;

        for (int d = 0; d <= limit; d++) {

            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            int nPrev1, nPrev2;

            if (prev1 == 10 && d == 0) {
                nPrev1 = 10;
                nPrev2 = 10;
            } else if (prev1 == 10) {
                nPrev1 = d;
                nPrev2 = 10;
            } else if (prev2 == 10) {
                nPrev1 = d;
                nPrev2 = prev1;
            } else {
                nPrev1 = d;
                nPrev2 = prev1;
            }

            long[] nxt = dfs(pos + 1, nPrev1, nPrev2, ntight);

            count += nxt[0];
            waviness += nxt[1];

            if (prev2 != 10) {

                if ((prev1 > prev2 && prev1 > d) ||
                    (prev1 < prev2 && prev1 < d)) {

                    waviness += nxt[0];
                }
            }
        }

        memoCnt[pos][prev1][prev2][tight] = count;
        memoWave[pos][prev1][prev2][tight] = waviness;

        return new long[]{count, waviness};
    }
}